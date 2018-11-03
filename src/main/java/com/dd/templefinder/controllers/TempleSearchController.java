package com.dd.templefinder.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dd.templefinder.models.Temple;
import com.dd.templefinder.services.TempleSearchServiceI;

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
    	List<Temple> templeList = templeService.getAllTemples();
    	model.addAttribute("templeList",templeList);
		return "searchResults";
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getTemples/{search}", method = RequestMethod.GET)
	public String searchTemplesList(@PathVariable("search") String searchString, Model model) throws IOException {
		List<Temple> templeResult = templeService.searchTemples(searchString);
		model.addAttribute("templeList",templeResult);
		return "searchResults";
	}
}
