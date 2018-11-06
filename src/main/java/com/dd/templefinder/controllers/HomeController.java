package com.dd.templefinder.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dd.templefinder.TemplefinderApplication;

public class HomeController {

	private static final Logger LOG = LogManager.getLogger(TemplefinderApplication.class);
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String showIndexPage() {
		LOG.debug("showIndexPage method::invoked - to show index.jsp");
		LOG.info("index.jsp will be returned");

		return "index";
	}
}
