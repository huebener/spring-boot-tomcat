package de.huebener.tomcat;

import java.util.Date;
import java.util.Map;

import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class WelcomeController {

	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	@GetMapping("/welcome")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		return "welcome";
	}
	 
  @RequestMapping("/hello")
	public String hello(Map<String, Object> model) {
		model.put("message", this.message);
		return "hello";
	}
    
  @RequestMapping("/fail")
	public @ResponseBody String fail() {
		return "Oh dear!";
	}
}