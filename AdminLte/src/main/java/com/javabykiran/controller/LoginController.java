package com.javabykiran.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.javabykiran.model.Users;
import com.javabykiran.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	
	@RequestMapping(value = "/login")
	public ModelAndView checkLogin(@ModelAttribute Users user,HttpServletRequest request) {
		// System.out.println("user >>> " + user);
		// System.out.println("checkLogin...........");
		ModelAndView mv = new ModelAndView();
		if (loginService.checkLogin(user) != null) {
			Users u = loginService.checkLogin(user);
			mv.setViewName("dashboard");
			String uname = u.getUsername();
			request.getSession().setAttribute("username", uname);
			//mv.addObject("username", u.getUsername());
			mv.addObject("data", loginService.loadUsers());
			mv.addObject("msg", "Login successfull as "+u.getUsername());
		} else {
			mv.addObject("msg", "your username/password is wrong..");
			mv.setViewName("login");
		}
		return mv;
	}
	
	@RequestMapping(value = "/")
	public String openLoginPage() {
		// System.out.println("openLoginPage..........");
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		System.out.println("logout");
		HttpSession httpSession = request.getSession();
		httpSession.invalidate();
		return "redirect:/loginpage";
	}

}
