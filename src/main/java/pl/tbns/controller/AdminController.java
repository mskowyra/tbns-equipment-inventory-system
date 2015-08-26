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
import org.springframework.web.servlet.ModelAndView;

import pl.tbns.model.User;
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

    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView users(@RequestParam(value = "success", required = false) String success) {
    	logger.info("Display list users site");
        
    	ModelAndView model = new ModelAndView();
    	if (success != null) {
    		logger.info("Zarejstowano urzykowników wyœwietl liste");
    		model.addObject("msg", "Zarejstowa³eœ nowego urzytkownika.");
    		
    	}
       model.addObject("users", userService.findAllUser());
       model.setViewName("admin.users.list");  
      
       return model;
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
    
    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editUser(@PathVariable("id") Long id, Model model) {
		User user = userService.findOneUserById(id);
		model.addAttribute("user", user);
		return "user.edit";
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

}

