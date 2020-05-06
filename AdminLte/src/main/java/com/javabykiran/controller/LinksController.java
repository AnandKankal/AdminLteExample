package com.javabykiran.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LinksController {
	@RequestMapping(value = "/links")
	public String links() {
		return "links";
	}
}
