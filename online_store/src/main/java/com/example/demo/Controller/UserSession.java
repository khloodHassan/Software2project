package com.example.demo.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Entity.User;

@Controller
public class UserSession {
	
	private static UserSession session;
	private String userType;
	private User user;
	
	public UserSession() {
		
	}
	public UserSession(String name,User user)
	{
		userType=name;
		this.user=user;
	}
	public static synchronized UserSession getCurrentSeesion(String userName,User user)
	{
		if(session==null)
		{
			redirectToCustomerLogin();
		}
		else
		{
			session=new UserSession(userName, user);
		}
		return session;
	}
	@GetMapping
	private static String redirectToCustomerLogin()
	{
		return "customerLogin";
	}
}
