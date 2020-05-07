package com.javabykiran.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javabykiran.model.Download;
import com.javabykiran.service.UserService;

@Controller
public class DownloadsController {
	
	@Autowired
	UserService userService;
	
	/*@RequestMapping(value = "/downloads")
	public String downloads() {
		return "downloads";
	}*/
	
	@RequestMapping("/downloads")
	public ModelAndView showDownloadList() {
		ModelAndView mv = new ModelAndView();
		if (userService.showDownloadList() != null) {
			List<Download> l = userService.showDownloadList();
			mv.setViewName("downloads");
			mv.addObject("data", userService.showDownloadList());
		} else {
			mv.addObject("msg", "List not available..please add.");
			mv.setViewName("downloads");
		}
		return mv;
	}
	
}
