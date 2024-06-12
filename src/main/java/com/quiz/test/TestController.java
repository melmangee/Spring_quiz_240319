package com.quiz.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class TestController {

	@ResponseBody
	@RequestMapping("/test1")
	public String test1() {
		return "Hello world!";
	}
}

