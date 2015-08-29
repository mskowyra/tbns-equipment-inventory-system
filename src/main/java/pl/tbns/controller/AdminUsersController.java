package pl.tbns.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pl.tbns.model.User;
import pl.tbns.service.UserService;

/**
 * @author Maciej Skowyra & Szymon Iwanski	
 * @date Aug 22, 2015 7:28:29 PM
 * 
 */
@Controller
@RequestMapping("/admin/users")
public class AdminUsersController {

	private Logger logger = LoggerFactory.getLogger(AdminUsersController.class);
	
    @Autowired
    private UserService userService;

    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listUser(
    		@RequestParam(value = "success", required = false) String success , 
    		@RequestParam(value = "remove", required = false) String remove) {
    	
    	logger.info("Display list users site");
        
    	ModelAndView model = new ModelAndView();
    	if (success != null) {
    		logger.info("Zarejstowano urzykownika, wyświetl liste");
    		model.addObject("msg", "Zarejstowano nowego urzytkownika.");
    		
    	}
    	if (remove != null) {
    		logger.info("Usunięto urzykownika, wyświetl liste");
    		model.addObject("msg", "Usunięto urzytkownika!");
    		
    	}
       model.addObject("users", userService.findAllUser());
       model.setViewName("admin.list.users");  
      
       return model;
    }
    
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String showRegister(Model model) {
    	logger.info("Display register form site");
    	model.addAttribute("user", new User());
        return "admin.register.user";
    }    
    
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
        	logger.info("Error registri user");
            return "admin.register.user";
        }
        
        userService.createUser(user);
        logger.info("Correct register user");        
        return "redirect:/admin/users?success";
    }
    
    @RequestMapping("/is-available")
    @ResponseBody
    public String available(@RequestParam String username) {
        Boolean available = userService.findOneUserByName(username) == null;
        logger.info("is-avaiable");
        return available.toString();
    }

    @RequestMapping("/{id}")
    public String detailsUser(@PathVariable Long id, Model model) {
    	logger.info("Display details conret user");
    	model.addAttribute("user", userService.findOneUserById(id));
    	return "admin.detail.user";
    }
    

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable Long id) {
    	logger.info("User are deleted");
    	userService.removeUser(id);
        return "redirect:/admin/users?remove";
    }
    
    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editUser(@PathVariable("id") Long id, Model model) {
		User user = userService.findOneUserById(id);
		model.addAttribute("user", user);
		return "admin.edit.user";
	}     
    
    @RequestMapping(value="/edit/{id}", method = RequestMethod.POST)
    public String updateUser(@PathVariable("id") Long id, @Valid  User user, BindingResult result) {
        if (result.hasErrors()) {
        	logger.info("Error registri user");
            return "admin.register.user";
        }
        logger.info("Correct register user");
        userService.createUser(user);
        return "redirect:/admin/users?success";
    }
    
    

}

