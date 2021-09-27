package be.intecbrussel.blogPost.services;

import be.intecbrussel.blogPost.model.Author;
import be.intecbrussel.blogPost.repositories.AuthorDetailImpl;
import be.intecbrussel.blogPost.repositories.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthorDetailService  implements UserDetailsService {

    @Autowired
    private AuthorRepo authorRepo;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Author author = authorRepo.findByEmail(email);
        if (author == null) {
            throw new UsernameNotFoundException("User not found user with that email" + email);
        }

        return new AuthorDetailImpl(author);
    }
}


