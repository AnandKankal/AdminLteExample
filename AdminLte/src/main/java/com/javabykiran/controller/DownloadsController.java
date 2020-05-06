package com.javabykiran.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DownloadsController {
	@RequestMapping(value = "/downloads")
	public String downloads() {
		return "downloads";
	}
}
