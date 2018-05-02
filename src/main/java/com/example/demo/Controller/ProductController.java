package com.example.demo.Controller;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.Repository.BrandRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductRep;

import java.util.ArrayList;
import java.util.List;

@Controller
//@EnableJpaRepositories("Repository")
public class ProductController {

	@Autowired
    private ProductRep productRepository;
	@Autowired
	private BrandRep brandRepository;

	@GetMapping("/addProduct")
	public String add(Model model)
	{
		model.addAttribute("product",new Product());
		return "addProduct";
	}
	
	@GetMapping("/addProductInDB")
    //public String addProduct(@RequestParam("name") String name,@RequestParam("price") String price
    //		,@RequestParam("brand") String brand,@RequestParam("category") String cat,@RequestParam("quantity") int quantity
    	//	,HttpServletRequest req)
	public String add(Model model,@ModelAttribute Product product,HttpServletRequest req)
    {
    	req.getSession().getAttribute("admin");
    	if(productRepository.findOne(product.getName() )==null)
    	{
    		if(brandRepository.findOne(product.getBrand())==null)//there is no brand like this
				System.out.println("there is no brand like this");
    		else {
				product.setNumOfViews(0);
				//Product pro=new Product(name,price,brand,cat,quantity);
				productRepository.save(product);
			}
    	}
    	else
    	{
    		System.out.println("already exists!");
    		return "addProduct";
    	}
    	return "addProductInDB";
    }

	@GetMapping("show-all-products")
	public String show(Model model)
	{
		Iterable<Product> productIteratable=productRepository.findAll();
		List<Product> products=new ArrayList<Product>();
		for(Product product:productIteratable)
		{
			products.add(product);
		}
		for(Product product:products)
		{
			int views=product.getNumOfViews();
			product.setNumOfViews(views++);
			System.out.println(views);
		}
		model.addAttribute("products",products);
		return "show-all-products";
	}
}
