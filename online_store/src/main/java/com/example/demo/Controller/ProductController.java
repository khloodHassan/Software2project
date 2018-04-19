package com.example.demo.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductRep;

@Controller
//@EnableJpaRepositories("Repository")
public class ProductController {

	@Autowired
    private ProductRep productRepository;
	
	@GetMapping("/addProduct")
    public String addProduct(@RequestParam("name") String name,@RequestParam("price") String price
    		,@RequestParam("brand") String brand,@RequestParam("category") String cat
    		,HttpServletRequest req)
    {
    	req.getSession().getAttribute("user");
    	if(productRepository.findOne(name)==null)
    	{
    		Product pro=new Product(name,price,brand,cat);
    		productRepository.save(pro);
    		productRepository.save(pro);
    	}
    	else
    	{
    		System.out.println("already exists!");
    	}
    	return "";
    }
}
