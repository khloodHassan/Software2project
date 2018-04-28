package com.example.demo.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Store;
import com.example.demo.Entity.User;
import com.example.demo.Interface.Observer;
import com.example.demo.Repository.UserRep;

public class AdminController extends Observer{

	UserRep userRep;
	UserSession session;
	
	@GetMapping
	@RequestMapping("/adminLogin")
	public String log()
	{
		return "/adminLoginPage";
	}
	
	
	@GetMapping
	@RequestMapping("/adminLoginPage")
	public String adminLogin(@RequestParam("email") String email, 
			@RequestParam("pass") String pass,@RequestParam("confirmPass") String confirmPass)
	{
		User user=new User();
		user=userRep.findOne(email);
		if(user.getPassword().equals(confirmPass))
		{
			user.setEmail(email);
			user.setPassword(pass);
			//session=session.getCurrentSeesion("admin", user);
		}
		
		return null;
	}
	
	@Override
	public String update(Store store) {
		
		return null;
	}
	
}
