package com.example.test.democode.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Put on any class where you want to make a REST controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String sayHi() {
		return "Hello";
	}

}
