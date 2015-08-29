package pl.tbns.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Maciej Skowyra & Szymon Iwanski	
 * @date Aug 22, 2015 4:43:06 PM
 * 
 */
@Controller
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(LoginController.class);

	
@RequestMapping(value = "/login", method = RequestMethod.GET)
public ModelAndView login(
	@RequestParam(value = "error", required = false) String error,
	@RequestParam(value = "logout", required = false) String logout) {

	logger.info("Display login site");
	
	ModelAndView model = new ModelAndView();
	if (error != null) {
		logger.info("Display login error site!");
		model.addObject("error", "Błędna nazwa urzytkownika lub hasło!");
	}

	if (logout != null) {
		logger.info("Display login correct site!");
		model.addObject("msg", "Zostałeś poprawnie wylogowany z systemu.");
	}
	model.setViewName("login.index");

	return model;

}

}