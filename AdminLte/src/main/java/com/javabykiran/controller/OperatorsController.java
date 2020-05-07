package com.javabykiran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javabykiran.service.UserService;

@Controller
public class OperatorsController {
	//@RequestMapping(value = "/operators")
	/*public String operators() {
		return "operators";
	}*/
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/operators")
	public ModelAndView operators() {
		ModelAndView mv = new ModelAndView();
		if (userService.showOperators() != null) {
			mv.setViewName("operators");
			mv.addObject("data", userService.showOperators());
		} else {
			mv.addObject("msg", "User not available..please add.");
			mv.setViewName("operators");
		}
		return mv;
	}
}
