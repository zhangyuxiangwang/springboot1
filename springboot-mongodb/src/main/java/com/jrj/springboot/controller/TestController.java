package com.jrj.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrj.springboot.GlobleConfig;

@RestController
public class TestController {
	
	@RequestMapping("/con")
	public GlobleConfig queryAllList(){

		return new GlobleConfig();
	}

}
