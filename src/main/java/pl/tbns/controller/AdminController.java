package pl.tbns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.tbns.service.UserService;

/**
 * @author Maciej Skowyra & Szymon Iwanski	
 * @date Aug 22, 2015 7:28:29 PM
 * 
 */
@Controller
@RequestMapping("/users")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public String users(Model model) {
        model.addAttribute("users", userService.findAllUser());
        return "users";
    }

    @RequestMapping("/{id}")
    public String deails(Model model, @PathVariable Long id) {
      
        return "user-detail";
    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable Long id) {
        userService.removeUser(id);
        return "redirect:/users";
    }

}
