package pl.tbns.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private Logger logger = LoggerFactory.getLogger(AdminController.class);
	
    @Autowired
    private UserService userService;

    @RequestMapping
    public String users(Model model) {
    	logger.info("Display list users site");
        model.addAttribute("users", userService.findAllUser());
        return "admin.users.list";
    }

    @RequestMapping("/{id}")
    public String details(Model model, @PathVariable Long id) {
    	logger.info("Display details conret user");
        return "user-detail";
    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable Long id) {
    	logger.info("User are deleted");
    	userService.removeUser(id);
        return "redirect:/users";
    }

}
