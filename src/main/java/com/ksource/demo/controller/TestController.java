package com.ksource.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zhang Dingjie
 * @date 2021/5/19
 * @Description
 */
@RestController
@RequestMapping(value = "/test/")
public class TestController {

	@RequestMapping(value = "getTest", method = RequestMethod.GET)
	public String getTest() {
		System.out.println("###~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~###");
		System.out.println("###~~~~~~~~~~~GET REQUEST APPROACHED~~~~~~~~~~~###");
		System.out.println("###~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~###");
		return "###~~~~~~~~~~~GET REQUEST APPROACHED~~~~~~~~~~~###";
	}

	@RequestMapping(value = "postTest", method = RequestMethod.POST)
	public String postTest() {
		System.out.println("<<<------------------------------------------------>>>");
		System.out.println("<<<---------------POST REQUEST APPROACHED--------------->>>");
		System.out.println("<<<------------------------------------------------>>>");
		return "<<<---------------POST REQUEST APPROACHED--------------->>>";
	}

	@RequestMapping(value = "delTest", method = RequestMethod.DELETE)
	public String deleteTest() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~DELETE REQUEST APPROACHED~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		return "~~~~~~~~~~~~~~DELETE REQUEST APPROACHED~~~~~~~~~~~~~~";
	}

	@RequestMapping(value = "putTest", method = RequestMethod.PUT)
	public String putTest() {
		System.out.println("------------------------------------------------------");
		System.out.println("------------------PUT REQUEST APPROACHED------------------");
		System.out.println("------------------------------------------------------");
		return "------------------DELETE REQUEST APPROACHED------------------";
	}

}
