package fr.fms.web;

import fr.fms.business.IBusinessImpl;
import fr.fms.dao.ArticleRepository;
import fr.fms.entities.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Controller
public class CartController {
    @Autowired
    IBusinessImpl iBusiness;

    @GetMapping("/cart")
    public String card(Model model) {
        HashMap<Long, Article> cart =  iBusiness.getCart();
        List<Article> articles = new ArrayList<>(cart.values());
        model.addAttribute("cartList", articles);
        return "cart";
    }

    @GetMapping("/rmFromCart")
    public String rmFromCart(Long id) {
        iBusiness.rmFromCart(id);
        return "redirect:/cart";
    }

}
