package pl.tbns.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.tbns.model.User;
import pl.tbns.service.UserService;

/**
 * @author Maciej Skowyra & Szymon Iwanski	
 * @date Aug 22, 2015 7:28:25 PM
 * 
 */
@Controller
@RequestMapping("/registered")
public class RegisterController {

	private Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
    @Autowired
    private UserService userService;

    @RequestMapping
    public String showRegister(Model model) {
    	logger.info("Display register form site");
    	model.addAttribute("user", new User());
        return "user.register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
        	logger.info("Error registri user");
            return "user.register";
        }
        logger.info("Correct register user");
        userService.cteateUser(user);
        return "redirect:users?success";
    }
    
    @RequestMapping("/is-availableed")
    @ResponseBody
    public String available(@RequestParam String username) {
        Boolean available = userService.findOneUserByName(username) == null;
        logger.info("is-avaiable");
        return available.toString();
    }
}