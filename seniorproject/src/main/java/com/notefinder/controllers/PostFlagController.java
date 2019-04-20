package com.notefinder.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.notefinder.models.PostFlag;
import com.notefinder.service.PostFlagManager;

@Controller
public class PostFlagController {
	// To be completed after creating PostFlagDao.java
	@Autowired
	PostFlagManager manager;

	@RequestMapping("/viewPostFlags")
	public String viewpost(Model m) {
		List<PostFlag> list = manager.getPostFlags();
		m.addAttribute("list", list);
		return "viewPostFlags";
	}

	@RequestMapping(value = "addPostFlag", method = RequestMethod.GET)
	public String viewAddPostFlag(@ModelAttribute("postFlagForm") PostFlag course, Map<String, Object> model) {
		PostFlag postFlagForm = new PostFlag();
		model.put("postFlagForm", postFlagForm);

		System.out.println("This one got called");

		PostFlag c = new PostFlag();

		System.out.println(c);
		return "addPostFlag";
	}

	@RequestMapping(value = "addPostFlag", method = RequestMethod.POST)
	public String addPostFlag(@ModelAttribute("postFlagForm") PostFlag cf, Map<String, Object> model) {
		System.out.println(cf);
		return "home";
	}
}
