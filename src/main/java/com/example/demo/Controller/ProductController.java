package com.example.demo.Controller;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.Entity.Store;
import com.example.demo.Entity.User;
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
    	if(product.getName()==""||product.getQuantity()<=0|| product.getBrand()==""||product.getPrice()==0||product.getCategory()=="" ||product.getStore()=="")
        {
            model.addAttribute("err","please enter another information");
            add(model);
			System.out.println("1");
            return "addProduct";
        }
    	req.getSession().getAttribute("admin");
    	if(productRepository.findOne(product.getName() )==null)
    	{
    		if(brandRepository.findOne(product.getBrand())==null || storeRepository.findOne(product.getStore())==null)//there is no brand like this
			{
				model.addAttribute("err", "there is no brand like this or there is no store like this");
				add(model);
				System.out.println("2");
				return "addProduct";
			}
    		else {
				product.setNumOfViews(0);
				//Product pro=new Product(name,price,brand,cat,quantity);
				System.out.println("3");
				productRepository.save(product);
			}
    	}
    	else
    	{
    		//System.out.println("already exists!");
            model.addAttribute("err","already exists!");
            add(model);
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
					  @RequestParam("amount") String amount1,@RequestParam("email") String email)
	{
	    int amount=Integer.parseInt(String.valueOf(amount1));
	    if(name==""||store==""||amount<=0||email=="")
        {
            model.addAttribute("err","please enter the information again");
            show(model);
            return "show-all-products";
        }
		Product product=productRepository.findOne(name);
		if(product!=null)
		{
			Store store1=storeRepository.findOne(store);
			if(store1!=null)
			{
				User user=userRepository.findOne(email);
				if(product.getQuantity()>=amount)
				{
					int quantity=product.getQuantity();
					productRepository.delete(product.getName());
					quantity-=amount;
					product.setQuantity(quantity);
					productRepository.save(product);

					double total=product.getPrice()*amount;
					if(userRepository.findOne(email).getUType().equals("storeOwner"))
                    {
                        total=total*85/100;
						System.out.println("storeOwner");
                    }
                    if(amount>2)
                    {
                        total=total*90/100;
						System.out.println(">2");
                    }
                    if(user.isFirstTime())
                    {
                        total=total*95/100;
                        user.setFirstTime(false);
                        userRepository.save(user);
						System.out.println("isFirstTime");
                    }

					String msg=Double.toString(total);
					model.addAttribute("total" ,msg);
				}
				else {
					System.out.println("you can't buy all this amount!!");
					show(model);
					model.addAttribute("err","you can't buy all this amount!!");
					return "show-all-products";
				}

			}
			else {
				System.out.println("there is no store like that!!");
				show(model);
				model.addAttribute("err","there is no store like that!!");
				return "show-all-products";
			}
		}
		else {
			System.out.println("there is no product like that!!");
			show(model);
			model.addAttribute("err","you can't product all this amount!!");
			return "show-all-products";
		}
		//return "show-all-products";
		return "buyProduct";
	}
}
