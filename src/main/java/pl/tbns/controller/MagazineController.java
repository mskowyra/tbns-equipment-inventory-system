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

import pl.tbns.model.Magazine;
import pl.tbns.service.MagazineService;

@Controller
@RequestMapping(value="/magazine")
public class MagazineController {
	private Logger logger = LoggerFactory.getLogger(MagazineController.class);
	
	@Autowired
	private MagazineService magazineService;	
	
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String createMagazine(Model model){
		model.addAttribute("magazine", new Magazine());
	return "magazine.create";	
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public String addMagazine(@Valid @ModelAttribute("magazine") Magazine magazine, BindingResult result){
		if(result.hasErrors()){
		logger.info("Error validate create Magazine");		
		}
		magazineService.createMagazine(magazine);
		return "redirect:/magazine?success";
	}	
	@RequestMapping(method = RequestMethod.GET)
	 public ModelAndView listMagazine(
	    		@RequestParam(value = "success", required = false) String success , 
	    		@RequestParam(value = "remove", required = false) String remove,
	    		@RequestParam(value = "edited", required = false) String edited) {	    	
	    	logger.info("Display list magazine site");	        
	    	ModelAndView model = new ModelAndView();
	    	if (success != null) {
	    		logger.info("Dodano nowy magazyn, wyświetl liste");
	    		model.addObject("msg", "Dodano nowy typ urządzenia.");	    		
	    	}if (remove != null) {
	    		logger.info("Usunięto magazyn, wyświetl liste");
	    		model.addObject("msg", "Usunięto urządzenie!");	    		
	    	}if (edited != null) {
	    		logger.info("Edytowano magazyn, wyświetl liste");
	    		model.addObject("msg", "Edytowano urządzenie.");	    		
	    	}
	       model.addObject("magazine", magazineService.findAllMagazine());
	       model.setViewName("magazine.list"); 	      
	       return model;
	    }
	 @RequestMapping("/remove/{id}")
	 public String removeMagazine(@PathVariable Long id) {
	    	logger.info("Magazine are deleted");
	    	magazineService.deleteMagazineById(id);
	        return "redirect:/magazine?remove";
	 }	
	 
	 @RequestMapping(value="/{id}")
	 public ModelAndView listEquipmentsInMagazine(@PathVariable Long id){
		 ModelAndView model = new ModelAndView();
		 model.addObject("magazineEquisList", magazineService.getMagazineLazyLoadById(id));
		 model.setViewName("magazine.equipments.list");
		 return model;
	 }
}
