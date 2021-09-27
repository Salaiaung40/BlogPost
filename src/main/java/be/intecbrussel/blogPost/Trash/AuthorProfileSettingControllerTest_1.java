package be.intecbrussel.blogPost.Trash;


import be.intecbrussel.blogPost.repositories.AuthorDetailImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorProfileSettingControllerTest_1 {

    /*
    @Autowired
    private AuthorDetailImpl authorDetailImpl;

    @Autowired
    public AuthorProfileSettingController(AuthorDetailImpl authorDetailImpl) {
        this.authorDetailImpl = authorDetailImpl;
    }
*/
    /*
    @Autowired
    private CustomAuthorDetailService customAuthorDetailService;

    public AuthorProfileSettingController(CustomAuthorDetailService customAuthorDetailService) {
        this.customAuthorDetailService = customAuthorDetailService;
    }

    public AuthorProfileSettingController() {
    }

     */
//    private AuthorDetailImpl authorDetailImpl;


    @GetMapping("/author/authorProfileSettingPageTest_1")
    //Change to Author Class and try to work
    public String authorSettingPage(@AuthenticationPrincipal AuthorDetailImpl authorDetailImpl, Model model
//                           , Author loginAuthor, Model model1

    ) {
        if (authorDetailImpl == null) {
            throw new UsernameNotFoundException("User not found user with that email");
        }
        String userEmail = authorDetailImpl.getUsername();

//        Object author = model.getAttribute("author", loginAuthor);
        model.addAttribute("authordetail", authorDetailImpl);
        model.addAttribute("message", "You are loged in as " + authorDetailImpl.getFullName());

//        model1.addAttribute("lgauthor", loginAuthor);


//        model.addAttribute("authorDetail", customAuthorDetailService);
//        model.addAllAttributes(<loginAuthor> , getClass(Author));


        return "authorProfileSettingPageTest_1";


    }

    /*
    //Working Code


    @GetMapping("/authorProfileSettingPage")
    //Change to Author Class and try to work
    public String authorSettingPage(@AuthenticationPrincipal AuthorDetailImpl loginAuthor,
                                    Model model) {
        if (loginAuthor == null) {
            throw new UsernameNotFoundException("User not found user with that email");
        }
        String userEmail = loginAuthor.getUsername();


        model.addAttribute("author", loginAuthor);

//        model.addAttribute("authorDetail", customAuthorDetailService);
//        model.addAllAttributes(<loginAuthor> , getClass(Author));


        return "authorProfileSettingPage";

    }
    */

    /*

    public String editAuthor(){


        return null;
    }

    public String saveAuthor(){

        return null;
    }

    public String deleteAuthor(){

        return null;
    }

     */

    /*

    @RequestMapping(value = "/authorSettingPage", method = RequestMethod.GET)
    public ModelAndView showAuthorDetailProfileInfo() {
        return new ModelAndView(
        model.addAttribute("lastName", author.getLastName());
        model.addAttribute("streetName", author.streetName();
        model.addAttribute("houseNo", author.houseNo);
          );
    }

    @RequestMapping(value = "/authorSettingPage/save", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("author")Author author,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("lastName", author.getLastName());
        model.addAttribute("streetName", author.streetName();
        model.addAttribute("houseNo", author.houseNo);
        return "authorSettingPage";
    }

     */
}
