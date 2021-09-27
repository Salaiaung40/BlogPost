package be.intecbrussel.blogPost.Trash;


import be.intecbrussel.blogPost.repositories.AuthorDetailImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorProfileSettingControllerTest_2 {

    @GetMapping("/author/authorProfileSettingPageTest_2")
    public String AuthorProfileSettingControllerTest_2(
            @AuthenticationPrincipal AuthorDetailImpl authorDetailImpl, Model model) {
        if (authorDetailImpl == null) {
            throw new UsernameNotFoundException("User not found user with that email");
        }
        model.addAttribute("authordetail", authorDetailImpl);
        model.addAttribute("message", "You are loged in as " + authorDetailImpl.getFullName());


        return "/author/authorProfileSettingPageTest_2";
    }


}
