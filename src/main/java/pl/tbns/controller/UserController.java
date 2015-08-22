package pl.tbns.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.tbns.model.User;
import pl.tbns.service.UserService;


/**
 * @author Maciej Skowyra & Szymon Iwanski	
 * @date Aug 22, 2015 3:50:12 PM
 * 
 */
@Controller
public class UserController {

	@Autowired
    private UserService userService;

    @RequestMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.findAllUser());
        return "users";
    }

    @RequestMapping("/users/{id}")
    public String deails(Model model, @PathVariable Long id) {
        model.addAttribute("user", userService.findOneUser(id));
        return "user-detail";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegister(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(@ModelAttribute("user") User user) {
        userService.cteateUser(user);
        return "redirect:register?success=true";
    }
    
    @RequestMapping("/account")
    public String account(Model model, Principal principal){
     //   String userName = principal.getName();
     //   model.addAttribute("user", userService.findOneWithBlogs(userName));
        return "user-detail";
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public String doAddBlog(Principal principal) {
   //     String name = principal.getName();
   //     blogService.save(blog, name);
        return "redirect:/account";
    }
    
    @RequestMapping("/users/remove/{id}")
    public String removeUser(@PathVariable Long id) {
            userService.removeUser(id);
            return "redirect:/users";
        }
}
