package be.intecbrussel.blogPost.repositories;

import be.intecbrussel.blogPost.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
    @Query("SELECT u FROM Author u WHERE u.email = ?1")
    public Author findByEmail(String email);

    //    @Query("UPDATE Author u SET u.enabled = ?2 WHERE u.id = ?1")
//    @Modifying
//    public void updateEnabledStatus (Long id, boolean enabled);
}
