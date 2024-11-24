package com.telusko.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.demo.dao.UsersDao;

@RestController
public class HomeController {
	
	@Autowired
	UsersDao userdao;

	@RequestMapping("addUser")
	public ModelAndView addUser(Users user,ModelAndView mv) {
		userdao.save(user);
		mv.addObject("user",user);
		mv.setViewName("home.jsp");
		return mv;
	}
	
	@PostMapping("/users")
	public Users addUsers(@RequestBody Users user) {
		userdao.save(user);
		return user;
	}
	
	@GetMapping("/user")
	public ModelAndView findUserById(@RequestBody Integer userId1,ModelAndView mv) {
		Users user =  userdao.findById(userId1).orElse(new Users());
		System.out.println(userdao.findByUserIdGreaterThan(2));
		System.out.println(userdao.findByLocation("mdu"));
		mv.addObject("user",user);
		mv.setViewName("home.jsp");
		return mv;
	}
	
	@DeleteMapping("/deleteUser")
	public Users delete(int userId) {
		Users user =  userdao.findById(userId).orElse(new Users());
		userdao.delete(user);
		return user;
	}
	
	@GetMapping("/getUsers")
	public List<Users> getUsers() {
		return userdao.findAll();
	}
	
	@PutMapping("/updateUser")
	public Users updateUser(@RequestBody  Users user) {
		userdao.save(user);
		return user;
	}
	
	@GetMapping("home")
	public String home() {
		return "home.jsp";
	}

}
