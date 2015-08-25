package pl.tbns.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

}

