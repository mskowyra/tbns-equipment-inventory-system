package pl.tbns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.tbns.service.UserService;


/**
 * @author Maciej Skowyra & Szymon Iwanski	
 * @date Aug 22, 2015 3:50:12 PM
 * 
 */
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
}
