package pl.tbns.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Maciej Skowyra & Szymon Iwanski	
 * @date Aug 22, 2015 4:43:06 PM
 * 
 */
@Controller
public class LoginController {

	    @RequestMapping("/login")
	    public String login() {
	        return "login";
	    }
	
}
