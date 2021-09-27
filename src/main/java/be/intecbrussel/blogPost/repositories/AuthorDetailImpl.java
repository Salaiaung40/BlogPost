package be.intecbrussel.blogPost.repositories;

import java.util.Collection;

import be.intecbrussel.blogPost.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class AuthorDetailImpl implements UserDetails {

    @Autowired
    private Author author;


    public AuthorDetailImpl(Author author) {
        this.author = author;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /*
        Set<Article> articles = author.getArticles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

         for (Article article : articles) {
            authorities.add(new SimpleGrantedAuthority(article.getName()));
        }
        return authorities;
         */
        return null;
    }

    @Override
    public String getPassword() {
        return author.getPassword();
    }

    @Override
    public String getUsername() {
        return author.getEmail();
    }
/*
 // This override method is login to App with Username.

    @Override
    public String getUsername() {
        return author.getUserName();
    }

 */

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public String getFullName() {
        return this.author.getFullName();
    }

    //Create method to call model (Author) variables
    public Author getAuthor() {
        return author;
    }


}
