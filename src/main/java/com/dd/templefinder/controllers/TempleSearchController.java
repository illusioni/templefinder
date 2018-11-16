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
	public String fetchAllTempleData(Model model,RedirectAttributes ra) throws IOException {
		String res;
		
		List<Temple> templeList = templeService.getAllTemples();
		
		if(templeList.isEmpty()) {
			res = redirect(ra, "No Temples found. Please try again", "redirect:/");
		}else {
			model.addAttribute("templeList", templeList);
			res = "searchResults";
		}
		
		if(LOG.isDebugEnabled()) {
			LOG.debug("searchResults.jsp is served with ->>" + templeList);
		}
		return res;
	}

	/**
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/getTemples/{search}", method = RequestMethod.GET)
	public String searchTemplesList(@PathVariable("search") String searchString, Model model, RedirectAttributes ra) throws IOException {
		List<Temple> templeResult = templeService.searchTemples(searchString);
		String res;
		if(templeResult.isEmpty()) {
			res = redirect(ra, "No Temples found. Please try again", "redirect:/");
		}
		else {
			model.addAttribute("templeList", templeResult);
			res = "searchResults";
		}

		return res;
	}


	private String redirect(RedirectAttributes redirectAttributes, String message, String redirectUrl) {
		redirectAttributes.addFlashAttribute("errorMessage", message);
		return redirectUrl;
	}
}
