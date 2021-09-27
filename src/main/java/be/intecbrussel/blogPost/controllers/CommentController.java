package be.intecbrussel.blogPost.controllers;

import be.intecbrussel.blogPost.model.Comment;
import be.intecbrussel.blogPost.repositories.CommentRepo;
import be.intecbrussel.blogPost.repositories.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private SecurityService securityService;

    public CommentController(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    @GetMapping("/author/createComment")
    public String showArticleForm(Model model) {
        model.addAttribute("comment", new Comment());
        return "author/createComment";
    }

    @PostMapping("/pro/process_comment")
    public String processPosting(Comment comment) {
        commentRepo.save(comment);
        return "redirect:/author/createComment";
    }
}
