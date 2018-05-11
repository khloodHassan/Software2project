package com.example.demo.Controller;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;

import com.example.demo.Repository.storeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Store;
import com.example.demo.Interface.Observer;
import java.util.*;

@Controller
//@EnableJpaRepositories("Repository")
public class StoreController {

	@Autowired
	storeRep storeRepository;

	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	public void attach(Observer observer)
	{
	      observers.add(observer);
	}

	@GetMapping("/addStore")
	public String addstore(Model model)
	{
		model.addAttribute("store",new Store());
		return "/addStore";
	}

	@GetMapping("/addedStore")
    public String addNewStore(Model model,@ModelAttribute Store store, HttpServletRequest req)
    {
    	if(store.getName()==""||store.getLocation()==""||store.getType()=="")
		{
			model.addAttribute("err","enter the information again");
			addstore(model);
			return "addStore";
		}
    	req.getSession().getAttribute("storeOwner");

		//we notify admin to add new store
    	/*for(int i=0;i<observers.size();i++)
    	{
    		observers.get(i).update(store);
    	}*/
    	//store.setAddress(null);
    	/*if(storeRepository.findOne(store.getName())!=null)
		{

		}*/
    	if(storeRepository.findOne(store.getName())==null)
			storeRepository.save(store);
    	else
		{
			model.addAttribute("err","already exists!!");
			addstore(model);
			return "addStore";
		}

    	return "addedStore";
    }
	
	@GetMapping("show-all-stores")
	public String showAll(Model model)
	{
		Iterable<Store> storeIterable=storeRepository.findAll();
		List<Store> stores=new ArrayList<Store>();
		for(Store store:storeIterable)
		{
			stores.add(store);
		}
		model.addAttribute("stores",stores);
		return "show-all-stores";
	}
	
}
