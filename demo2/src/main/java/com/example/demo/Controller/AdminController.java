package com.example.demo.Controller;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.Entity.Product;
import com.example.demo.Repository.storeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Store;
import com.example.demo.Entity.User;
import com.example.demo.Interface.Observer;
import com.example.demo.Repository.UserRep;

import java.util.ArrayList;
import java.util.List;

public class AdminController extends Observer{
	@Autowired
	UserRep userRep;
	//UserSession session;
	storeRep storeRepository;
	ArrayList<Store> unSavedStores=new ArrayList<Store>();
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
	public void update(Store store)
	{
		unSavedStores.add(store);
		System.out.println(store.getName());
	}

	@GetMapping("AdminHome")
	public String show(Model model, HttpServletRequest request)
	{
		Iterable<Store> storeIterable=storeRepository.findAll();
		List<Store> stores=new ArrayList<Store>();
		for(Store store:storeIterable)
		{
			stores.add(store);
		}
		model.addAttribute("stores",stores);
		return "AdminHome";
	}

	@GetMapping("/addStoryByAdmin")
	public String addToDB() {
		for(Store store:unSavedStores)
		{
			storeRepository.save(store);
		}
		unSavedStores.clear();
		return "adminHome";
	}
	
}
