package fr.fms.web;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class ArticleController {
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/index")
    public String index(Model model, @RequestParam(name="page", defaultValue = "0") int page,
                                     @RequestParam(name = "keyword", defaultValue = "") String kw,
                                     @RequestParam(name = "categoryId", required = false) Long categoryId) {
        Page<Article> articles;
        if (categoryId != null) {
            articles = articleRepository.findByCategoryIdAndDescriptionContains(categoryId, kw, PageRequest.of(page, 5));
        } else {
            articles = articleRepository.findByDescriptionContains(kw, PageRequest.of(page, 5));
        }

        model.addAttribute("listArticle", articles.getContent());
        model.addAttribute("pages", new int[articles.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("categoryId", categoryId);

        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("listCategory", categories);

        return"articles";
    }

    @GetMapping("/delete")
    public String delete(Long id, int page, String keyword) {
        articleRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/article")
    public String article(Model model) {
        model.addAttribute("article", new Article());
        return "article";
    }

    @PostMapping("/save")
    public String save(@Valid Article article, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return "article";
        articleRepository.save(article);
        return "redirect:/index";
    }

    @GetMapping("/article_update")
    public String articleUpdate(@RequestParam("id") Long articleId, Model model) {
        Optional<Article> article = articleRepository.findById(articleId);
        model.addAttribute("article", article.orElse(new Article()));
        return "article_update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("article") @Valid Article article, BindingResult bindingResult, @RequestParam("id") Long articleId) {
        if(bindingResult.hasErrors()) return "article_update";
        article.setId(articleId);
        articleRepository.save(article);
        return "redirect:/index";
    }
}
