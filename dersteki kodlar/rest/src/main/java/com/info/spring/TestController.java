package com.info.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@GetMapping("/message")
	@ResponseBody //içeriği doğrudan döndürür
	public String getMessage() {
		return "test message";
	}
}
