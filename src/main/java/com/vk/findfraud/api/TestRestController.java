package com.vk.findfraud.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vk.findfraud.database.DatabaseUtil;

@RestController
@RequestMapping("test")
public class TestRestController {

	// test Brand
	@RequestMapping(value = "/test", produces = "application/json")
	public String testBrand() {

		DatabaseUtil.getSessionFactory();
		return "pass";
	}
}
