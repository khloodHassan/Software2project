package com.example.demo.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Store;
import com.example.demo.Interface.Observer;
import java.util.*;

@Controller
//@EnableJpaRepositories("Repository")
public class StoreController {

	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	public void attach(Observer observer)
	{
	      observers.add(observer);
	}
	
	@GetMapping("/addNewStore")
    public String addNewStore(@RequestParam("name") String name,@RequestParam("storeLocation") String storeLocation,@RequestParam("storeAddress") String storeAddress,@RequestParam("storeType") String storeType,HttpServletRequest req)
    {
    	req.getSession().getAttribute("storeOwner");
    	Store store=new Store(name,storeLocation,storeAddress,storeType);
    	for(int i=0;i<observers.size();i++)
    	{
    		observers.get(i).update(store);
    	}
    	return "addNewStore";
    }
	
	
	
}
