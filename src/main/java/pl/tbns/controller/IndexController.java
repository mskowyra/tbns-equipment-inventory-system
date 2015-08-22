package pl.tbns.controller;

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

	@RequestMapping(method = RequestMethod.GET)
	public String index(){
		return "index";
	}
}
