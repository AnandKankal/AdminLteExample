package com.javabykiran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javabykiran.model.Users;
import com.javabykiran.service.LoginService;
import com.javabykiran.service.RegisterService;

@Controller
public class RegisterController {
	
	@Autowired
	RegisterService registerService;
	
	@RequestMapping("/register")
	public String register() {
	    return "register";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard() {

	    return "dashboard";
	}
	
	@RequestMapping("/registerUser")
	public ModelAndView registerUser(@ModelAttribute Users user) {
		//System.out.println("registerUser controller");
		ModelAndView mv = new ModelAndView();
		registerService.registerUser(user);
		mv.addObject("msg", "Regisration done..login now.");
		mv.setViewName("login");
		return mv;
	}
}
