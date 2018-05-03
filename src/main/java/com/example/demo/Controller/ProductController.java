package com.example.demo.Controller;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.Entity.Store;
import com.example.demo.Repository.BrandRep;
import com.example.demo.Repository.UserRep;
import com.example.demo.Repository.storeRep;
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
	@Autowired
	private storeRep storeRepository;
	@Autowired
    private UserRep userRepository;

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
    		if(brandRepository.findOne(product.getBrand())==null || storeRepository.findOne(product.getStore())==null)//there is no brand like this
				System.out.println("there is no brand like this or there is no store like this");
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
		productRepository.deleteAll();

		for(Product product:products)
		{
			int views=product.getNumOfViews();
			//Product temp=new Product();
			//temp.setName(product.getName());
			//temp.setQuantity(product.getQuantity());
			product.setNumOfViews(views++);
			//temp.setNumOfViews(product.getNumOfViews()+1);
			productRepository.save(product);
			//System.out.println(views);
		}
		//productRepository.save(products);
		model.addAttribute("products",products);
		return "show-all-products";
	}

	@GetMapping("buyProduct")
	public String buy(Model model,@RequestParam("name") String name,@RequestParam("store") String store,
					  @RequestParam("amount") int amount,@RequestParam("email") String email)
	{
		Product product=productRepository.findOne(name);
		if(product!=null)
		{
			Store store1=storeRepository.findOne(store);
			if(store!=null)
			{
				if(product.getQuantity()>=amount)
				{

					int quantity=product.getQuantity();
					productRepository.delete(product.getName());
					product.setQuantity(quantity--);
					productRepository.save(product);

					double total=product.getPrice()*amount;
					if(userRepository.findOne(email).equals("storeOwner"))
                    {
                        total=total*85/100;
                    }
                    if(amount>2)
                    {
                        total=total*90/100;
                    }
                    if(product.isFirstTime())
                    {
                        total=total*95/100;
                        product.setFirstTime(false);
                        productRepository.save(product);
                    }

					String msg=Double.toString(total);
					model.addAttribute("total" ,msg);
				}
				else {
					System.out.println("you can't buy all this amount!!");
					model.addAttribute("err","you can't buy all this amount!!");
					return "show-all-products";
				}

			}
			else {
				System.out.println("there is no store like that!!");
				model.addAttribute("err","there is no store like that!!");
				return "show-all-products";
			}
		}
		else {
			System.out.println("there is no product like that!!");
			model.addAttribute("err","you can't product all this amount!!");
			return "show-all-products";
		}
		//return "show-all-products";
		return "buyProduct";
	}
}
