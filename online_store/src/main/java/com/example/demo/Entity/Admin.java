package com.example.demo.Entity;

import org.springframework.web.bind.annotation.GetMapping;

public class Admin extends User{
	
	@GetMapping("/notifyStoreOwner")
	public void notifyStoreOwner()
	{
		
	}
}
