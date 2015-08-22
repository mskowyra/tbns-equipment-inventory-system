package pl.tbns.controller;

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
        return "user-register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(@ModelAttribute("user") User user) {
        userService.cteateUser(user);
        return "user-register";
    }
}
