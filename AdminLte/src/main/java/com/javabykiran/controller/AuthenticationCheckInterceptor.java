package com.javabykiran.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthenticationCheckInterceptor extends HandlerInterceptorAdapter  {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //Check if user exists in session. 
        //If no, redirect to login page using response.sendRedirect() and return false
        //If yes, return true
		String user = (String) request.getSession().getAttribute("username");
		System.out.println("Inside pre handle");
		System.out.println(user);
		return true;
	}
    
	
	@Override
	public void postHandle(
	  HttpServletRequest request, 
	  HttpServletResponse response,
	  Object handler, 
	  ModelAndView modelAndView) throws Exception {
	     
	    //log.info("[postHandle][" + request + "]");
	    String username = (String) request.getSession().getAttribute("username");
	    
	    System.out.println("Inside post handle");
	    System.out.println(username);
	    
	   
	
	
	}
}
