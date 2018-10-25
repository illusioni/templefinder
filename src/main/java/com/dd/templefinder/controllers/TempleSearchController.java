package com.dd.templefinder.controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dd.templefinder.models.TempleModel;
import com.dd.templefinder.services.TempleSearchServiceI;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author aditya
 *
 */
@Controller
public class TempleSearchController {
	
	private static final Logger logger = LogManager.getLogger(TempleSearchController.class);
	
	@Autowired
	private TempleSearchServiceI templeService;
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getAllTemples", method = RequestMethod.GET)
	public String fetchAllTempleData(Model model) throws IOException {
    	logger.debug("Hello I am debug logger");
    	List<TempleModel> templeModelList = templeService.getAllTemples();
    	model.addAttribute("templeList",templeModelList);
		return "searchResults";
		
	}
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getTemples", method = RequestMethod.GET)
	public String searchTemplesList(Model model) throws IOException {
    	logger.debug("Hello I am debug logger");
		return "searchResults";
	}
}
