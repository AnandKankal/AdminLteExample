package com.javabykiran.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OperatorsController {
	@RequestMapping(value = "/operators")
	public String operators() {
		return "operators";
	}
}
