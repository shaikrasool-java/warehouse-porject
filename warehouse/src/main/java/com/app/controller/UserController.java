package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.User;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;

	@RequestMapping("/reg")
	public String showUser(Model model) {
		model.addAttribute("user", new User());
		return "UserRegister";
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user, Model model) {
			
		service.saveUser(user);
		model.addAttribute("user", new User());
		model.addAttribute("message", "User Created Succesfully");
		return "UserRegister";
	}
}
