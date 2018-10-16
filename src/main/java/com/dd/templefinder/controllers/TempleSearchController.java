package com.dd.templefinder.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class TempleSearchController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String fetchAll(Map<String, Object> model) {
		return "index";
		
	}

}
