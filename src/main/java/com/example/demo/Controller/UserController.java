package com.example.demo.Controller;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRep;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
//@EnableJpaRepositories("Repository")
public class UserController {
	@Autowired
	private UserRep userRepository;

	@GetMapping("/login")
	public String loginPage( Model model) {
		model.addAttribute("name", new User());
		return "customerLoginPage";
	}

	@PostMapping("/loggedin")
	public ModelAndView login (@RequestParam Map<String, String> body,HttpServletRequest request) {
		//System.out.println("email="+body.);
		System.out.println(body.get("email"));
		User user = userRepository.findOne(body.get("email"));
		if (user != null ) {
			if (user.getUType().equals("customer")) {
				request.getSession().setAttribute("customer",user);
				ModelAndView mv = new ModelAndView();
				mv.setViewName("customerHome");
				mv.addObject("name", user);
				//return "customerHome";
				return  mv;
			} else if (user.getUType().equals("admin")) {
				request.getSession().setAttribute("admin",user);
				ModelAndView mv = new ModelAndView();
				mv.setViewName("adminHome");
				mv.addObject("name", user);
				//return "AdminHome";
				return mv;
			}
			else{
				request.getSession().setAttribute("storeOwner",user);
				ModelAndView mv = new ModelAndView();
				mv.setViewName("storeOwnerHome");
				mv.addObject("name", user);
				//return "storeOwnerHome";
				return mv;
			}
		} else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("customerHome");
			mv.addObject("err", "Your username or password is incorrect");
			//return "login";
			return mv;
		}
		//return "/addProduct";
	}
	/*

	public String login (@RequestParam("email") String email,@RequestParam("password") String password,HttpServletRequest request) {

		System.out.println("email="+email);
        User user = userRepository.findOne(email);
        if (user != null ) {
            if (user.getUType().equals("customer")) {
                ModelAndView mv = new ModelAndView();
                mv.setViewName("customerHome");
                mv.addObject("name", user);
                return "customerHome";
            } else if (user.getUType().equals("admin")) {
                ModelAndView mv = new ModelAndView();
                mv.setViewName("adminHome");
                mv.addObject("name", user);
                return "adminHome";
            }
            else{
                ModelAndView mv = new ModelAndView();
                mv.setViewName("storeOwnerHome");
                mv.addObject("name", user);
                return "storeOwnerHome";
            }
        } else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("customerHome");
			mv.addObject("err", "Your username or password is incorrect");
			return "customerHome";
		}
		//return "customerHome";
	}*/

	@GetMapping("/register")
    public String register1(Model model)
    {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/registered")
    public String register(Model model ,@ModelAttribute User user){

		if (userRepository.exists(user.getEmail()) == false)// don't have an account
		{
			if (user.getPassword().equals(user.getConfirm())) {
				if (user.getUType() == "customer") {
					//request.getSession().setAttribute("customer", user);
					userRepository.save(user);
					return "customerHomePage";
				} else if (user.getUType() == "admin") {
					//request.getSession().setAttribute("admin", user);
					userRepository.save(user);
					return "adminHomePage";
				} else if (user.getUType() == "storeOwner") {
					//request.getSession().setAttribute("storeOwner", user);
					userRepository.save(user);
					return "storeOwnerHomePage";
				}

			} else {
				System.out.println("try again");

			}
			System.out.println(user.getEmail());
			userRepository.save(user);
		}

		return null;

	}


}
