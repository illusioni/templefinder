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

	private static final Logger LOG = LogManager.getLogger(TempleSearchController.class);

	@Autowired
	private TempleSearchServiceI templeService;

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getAllTemples", method = RequestMethod.GET)
	public String fetchAllTempleData(Model model) throws IOException {
		LOG.info("Request reached search controller");
		LOG.debug("Controller:fetchAllTempleData()::invoked");

		List<Temple> templeList = templeService.getAllTemples();

		LOG.info("Service call succesfull to get all temples" + templeList);
		model.addAttribute("templeList", templeList);

		LOG.debug("searchResults.jsp is served with ->>" + templeList);
		LOG.debug("Controller:fetchAllTempleData()::complete");
		return "searchResults";
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getTemples/{search}", method = RequestMethod.GET)
	public String searchTemplesList(@PathVariable("search") String searchString, Model model) throws IOException {
		LOG.info("Request reached search controller");
		LOG.debug("Controller:searchTemplesList()::invoked with searchString= " + searchString);

		List<Temple> templeResult = templeService.searchTemples(searchString);
		LOG.info("Service call succesfull to get filtered temples based on user input" + templeResult);

		model.addAttribute("templeList", templeResult);

		LOG.debug("The filter response for searchString->>" + searchString + "::size is:" + templeResult.size() +"with tempes->>" + templeResult);
		LOG.debug("Controller:searchTemplesList()::complete");

		return "searchResults";
	}
}
