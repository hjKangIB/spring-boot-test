package hello.hellospring.controller;

import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@PostMapping("login")
	public Map<String, Object> login(Model model) {
		
		return null;
	}
}
