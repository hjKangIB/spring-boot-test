package hello.hellospring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@GetMapping("hello")
	public String hello(Model model) {
		model.addAttribute("data", "hello!");
		return "hello";
	}

	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
		model.addAttribute("name", name);
		return "hello-mvc";
	};

	@GetMapping("hello-string")
	@ResponseBody
	public String helloString(@RequestParam("name") String name) {
		return "hello " + name;
	}

	@GetMapping("hello-api")
	@ResponseBody
	public Hello helloApi(@RequestParam(value = "name", required = false) String name, @RequestParam("age") String age) {
		Hello hello = new Hello();
		hello.addUser(name, age);
		return hello;

	}

	static class Hello {
		private HashMap<String, String> user;
		
		public Hello () {
			user = new HashMap<String, String>();
		}

		public HashMap<String, String> getUser() {
			return user;
		}

		public void addUser(String name, String age) {
			user.put(name, age);
		}
	}

}