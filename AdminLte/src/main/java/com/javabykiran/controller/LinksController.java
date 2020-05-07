package com.javabykiran.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javabykiran.model.Download;
import com.javabykiran.model.Links;
import com.javabykiran.service.UserService;

@Controller
public class LinksController {
	//@RequestMapping(value = "/links")
	/*public String links() {
		return "links";
	}*/
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/links")
	public ModelAndView links() {
		ModelAndView mv = new ModelAndView();
		if (userService.showLinkList() != null) {
			List<Links> l = userService.showLinkList();
			mv.setViewName("links");
			mv.addObject("data", userService.showLinkList());
		} else {
			mv.addObject("msg", "List not available..please add.");
			mv.setViewName("links");
		}
		return mv;
	}
}
