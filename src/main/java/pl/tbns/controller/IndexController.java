package pl.tbns.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author Maciej Skowyra & Szymon Iwanski	
 * @date Aug 22, 2015 1:26:48 PM
 * 
 */

@Controller
@RequestMapping("/")
public class IndexController {

	private Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(){
		logger.info("Display Start Site!");
		return "index";
	}
}
