package com.dd.templefinder.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dd.templefinder.models.Temple;
import com.dd.templefinder.services.TempleSearchServiceI;

/**
 * @author aditya
 *
 */
@Controller
public class TempleSearchController {

	private static final Logger LOG = LogManager.getLogger(TempleSearchController.class);

	@Autowired
	private TempleSearchServiceI templeService;

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getAllTemples", method = RequestMethod.GET)
	public String fetchAllTempleData(Model model,RedirectAttributes redirectAttributes) {
		LOG.info("Request reached search controller");
		LOG.debug("Controller:fetchAllTempleData()::invoked");

		List<Temple> templeList = new ArrayList<Temple>();
		try {
			templeList = templeService.getAllTemples();
		} catch (IOException e) {
			redirectAttributes.addFlashAttribute("errorMessage","No Temples found. Please try again");
			LOG.error("Could not read the Repo to get the temples" + e);
			return "redirect:/";
		}
		LOG.info("Service call succesfull to get all temples" + templeList);
		model.addAttribute("templeList", templeList);

		if(LOG.isDebugEnabled()) {
			LOG.debug("searchResults.jsp is served with ->>" + templeList);
		}
		LOG.debug("Controller:fetchAllTempleData()::complete");
		return "searchResults";
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getTemples/{search}", method = RequestMethod.GET)
	public String searchTemplesList(@PathVariable("search") String searchString, Model model,RedirectAttributes redirectAttributes)  {
		LOG.info("Request reached search controller");
		if(LOG.isDebugEnabled()) {
			LOG.debug("Controller:searchTemplesList()::invoked with searchString= " + searchString);
		}
		List<Temple> templeResult = new ArrayList<Temple>();
		try {
			templeResult = templeService.searchTemples(searchString);
		} catch (IOException e) {
			redirectAttributes.addFlashAttribute("errorMessage","No Temples found. Please try again");
			LOG.error("Could not read the Repo to get the temples" + e);
			return "redirect:/";
		}
		LOG.info("Service call succesfull to get filtered temples based on user input" + templeResult);

		model.addAttribute("templeList", templeResult);
		if(LOG.isDebugEnabled()) {
			LOG.debug("The filter response for searchString->>" + searchString + "::size is:" + templeResult.size() +"with tempes->>" + templeResult);
		}
		LOG.debug("Controller:searchTemplesList()::complete");
		return "searchResults";
	}
}
