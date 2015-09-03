package pl.tbns.controller;

import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;

import pl.tbns.model.Equipment;
import pl.tbns.model.EquipmentsType;
import pl.tbns.service.EquipmentService;
import pl.tbns.service.EquipmentsTypeService;

@Controller
@RequestMapping("/equipments")
public class EquipmentController {
	
	private Logger logger = LoggerFactory.getLogger(EquipmentController.class);
	
	@Autowired
	private EquipmentService equipmentService;
	
	@Autowired
	private EquipmentsTypeService equipmentsTypeService;
	
	
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String createEquipment(Model model){
		model.addAttribute("equipmentsTypes", equipmentsTypeService.findAllEquipmentsType());
		model.addAttribute("equipment", new Equipment());
		return "equipment.create";
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public String saveEquipment(@Valid @ModelAttribute("equipment") Equipment equipment, BindingResult result,@RequestParam("equipmentsType.id") Long equipmentsType, Model model) {
        if (result.hasErrors()) {
        	logger.info("Error registri equipment");
        	model.addAttribute("equipmentsTypes", equipmentsTypeService.findAllEquipmentsType());
            return "equipment.create";
        }        
        equipmentService.createEquipment(equipment, equipmentsType);
        logger.info("Correct register equipments");        
        return "redirect:/equipments?success";
    } 
	
	 @RequestMapping(method = RequestMethod.GET)
	 public ModelAndView listEqupipmentsType(
	    		@RequestParam(value = "success", required = false) String success , 
	    		@RequestParam(value = "remove", required = false) String remove,
	    		@RequestParam(value = "edited", required = false) String edited) {
	    	
	    	logger.info("Display list equipments type site");
	        
	    	ModelAndView model = new ModelAndView();
	    	if (success != null) {
	    		logger.info("Dodano nowy typ urządzenia, wyświetl liste");
	    		model.addObject("msg", "Dodano nowy typ urządzenia.");
	    		
	    	}
	    	if (remove != null) {
	    		logger.info("Usunięto typ urządzenia, wyświetl liste");
	    		model.addObject("msg", "Usunięto typ urządzenia!");
	    		
	    	}
	    	if (edited != null) {
	    		logger.info("Edytowano typ urządzenia, wyświetl liste");
	    		model.addObject("msg", "Edytowano typ urządzenia.");
	    		
	    	}
	       model.addObject("equipment", equipmentService.findAllEquipment());
	       model.setViewName("equipment.list");  
	      
	       return model;
	    }
/*
	 	@RequestMapping("/type/{id}")
	    public String detailsUser(@PathVariable Long id, Model model) {
	    	logger.info("Display details conret user");
	    	model.addAttribute("equipmentsType", equipmentsTypeService.findEquipmentsNoLazyLoadByIdWithoutEquipment(id));
	    	return "equipment.type.details";
	    }
	    

	    @RequestMapping("/type/remove/{id}")
	    public String removeUser(@PathVariable Long id) {
	    	logger.info("User are deleted");
	    	equipmentsTypeService.deleteEqiupmentsTypeById(id);
	        return "redirect:/type?remove";
	    }
	    
	    @RequestMapping(value="/type/edit/{id}", method=RequestMethod.GET)
		public String editUser(@PathVariable("id") Long id, Model model) {
	    	EquipmentsType equipmentsType = equipmentsTypeService.findEquipmentsNoLazyLoadByIdWithoutEquipment(id);
			model.addAttribute("equipmentsType", equipmentsType);			
			return "equipment.type.edit";
		}     
	    
	    @RequestMapping(value="/type/edit/{id}", method = RequestMethod.POST)
	    public String updateUser(@PathVariable("id") Long id, @Valid  EquipmentsType equipmentsType, BindingResult result) {
	        if (result.hasErrors()) {
	        	logger.info("Error registri user");
	            return "equipment.type.edit";
	        }
	        logger.info("Correct register user");
	        equipmentsTypeService.createEquipmentsType(equipmentsType);
	        return "redirect:/equipment/type?edited";
	    }
	    */
	    
}
