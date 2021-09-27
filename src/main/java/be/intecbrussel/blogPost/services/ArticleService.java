package be.intecbrussel.blogPost.services;

import be.intecbrussel.blogPost.model.Article;
import be.intecbrussel.blogPost.repositories.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class ArticleService {

    @Autowired
    ArticleRepo articleRepo;

    //this method not really need it in here because it already has at "articleRepo" -> at JpaRepository.
    public void save(Article article) {
        articleRepo.save(article);
    }

    public List<Article> listAll() {
        return (List<Article>) articleRepo.findAll();
    }

    public Article get(Long id) {
        return articleRepo.findById(id).get();
    }

    public void delete(Long id) {
        articleRepo.deleteById(id);
    }
}
