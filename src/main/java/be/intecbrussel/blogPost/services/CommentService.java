package be.intecbrussel.blogPost.services;

import be.intecbrussel.blogPost.model.Comment;

import java.util.List;

public interface CommentService {

    Comment findById(Long id);

    Comment saveComment(Long postId, Long userId);

    List<Comment> findAll();

    void deleteById(Long commentId);
}
