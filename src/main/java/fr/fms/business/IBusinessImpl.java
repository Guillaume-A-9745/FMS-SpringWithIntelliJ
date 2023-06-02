package fr.fms.business;

import fr.fms.dao.ArticleRepository;
import fr.fms.entities.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class IBusinessImpl implements IBusiness{

    @Autowired
    ArticleRepository articleRepository;

    private HashMap<Long, Article> cart;

    public IBusinessImpl() {
        cart = new HashMap<>();
    }

    public HashMap<Long,Article> getCart() {
        return cart;
    }

    public void addToCart(Article article) {
        cart.put(article.getId(), article);
    }

    public void rmFromCart(Long id) {
        Article article = cart.get(id);
        if(article != null) {
            cart.remove(id);
        }
    }
}
