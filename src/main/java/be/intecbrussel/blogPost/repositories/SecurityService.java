package be.intecbrussel.blogPost.repositories;

public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
}
