package be.intecbrussel.blogPost.controllers;

import be.intecbrussel.blogPost.model.Article;
import be.intecbrussel.blogPost.repositories.ArticleRepo;
import be.intecbrussel.blogPost.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticleController {

    @Autowired
    private ArticleRepo articleRepo;

    @Autowired
    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleRepo articleRepo) {
        this.articleRepo = articleRepo;
    }

    @GetMapping("/author/createArticle")
    public String showArticleForm(Model model) {
        model.addAttribute("article", new Article()); // add new article

//        model.addAttribute("articles", articleRepo.findAllById(Author, Long) );

        return "author/createArticle";
    }

    @PostMapping("/pro/process_article")
    public String processPosting(Article article) {
        articleRepo.save(article);
        return "redirect:/author/authorBlogHome";
    }

    //List all atricles
    @GetMapping("/listArticles")
    public String listArticles(Model model) {
        model.addAttribute("articles", articleRepo.findAll()); // calling all articles

        return "listArticles";

    }

//Show only one Article {id} for reader
//    @RequestMapping("/articleDetail/{id}")
//    public ModelAndView readArticle(@RequestParam long id) {
//        ModelAndView mav = new ModelAndView("articleDetail");
//        Article article = articleService.get(id); // this method is constructed in Service
//        mav.addObject("articledt", article);
//
//        return mav;
//    }


    @RequestMapping("/articleDetail/{id}")
    public String showArticle(@PathVariable("id") Long id, Model model) {
        Article article = articleService.get(id);
        model.addAttribute("articledt", article);

        return "articleDetail";
    }


//    //testing
//    @GetMapping("/articleDetail")
//    public String showArticleDetail() {
//        return "articleDetail";
//    }


//    @RequestMapping("/edit")
//    public ModelAndView editCustomerForm(@RequestParam long id) {
//        ModelAndView mav = new ModelAndView("edit_article");
//        Article article = articleService.get(id); // this method is constructed in Service
//        mav.addObject("article", article);
//
//        return mav;
//    }


}
