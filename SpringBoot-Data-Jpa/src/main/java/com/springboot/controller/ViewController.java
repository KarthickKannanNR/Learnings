package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.entity.UserVO;
import com.springboot.service.UserService;

@Controller
public class ViewController {

	@Autowired
	UserService userService;
	
	@GetMapping("allUsersView")
	public String getAllUsersAsView(Model model,@RequestParam int id) throws Exception{
		List<UserVO> users = userService.getAllUsers();
		model.addAttribute("users",users);
		return "user";
	}
}
