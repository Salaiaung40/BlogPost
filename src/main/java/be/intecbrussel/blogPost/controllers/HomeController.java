package be.intecbrussel.blogPost.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {



//    @Autowired
//    private AuthorProfileRepo prorepo;

    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }



//    @GetMapping("/process_SettingPage")
//    public String processProfile (Author author){
//        prorepo.findById(author.getId());
//        return "authorProfileSettingPage";
//    }



//    @GetMapping("/AuthorSettingPage")
//    public String AprofilePage(Model model) {
//
//        return "authorProfileSettingPage";
//    }


}
