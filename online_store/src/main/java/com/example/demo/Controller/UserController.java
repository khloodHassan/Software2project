package com.example.demo.Controller;



import javax.servlet.http.HttpServletRequest;

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
	private UserRep use;

	//@GetMapping("/login")
	@GetMapping("/login")

	public String loginPage( Model model) {
		model.addAttribute("name", new User());
		return "customerLoginPage";
	}

	//@PostMapping("/login")
    //@Secured(AuthoritiesConstants.USER)
	@RequestMapping(value = "/customerHome",method = RequestMethod.POST)
	public ModelAndView index (@RequestParam Map<String, String> body) {
        System.out.println(body);
		/* Optional <User> userObj = use.findOne(email);
		Object user = new User();
		user = use.findOne(user.getEmail());
		if (((User) user).getPassword().equals(pass))// casting
		{

			req.getSession().setAttribute("user", user);
			// req.getClass().
		}*//*
		User userObj=use.findOne(user.getEmail());
		if(user!=null && user.getPassword().equals(user.getPassword()))
		{
			model.addAttribute("student",new User ());
			return "customerLoginPage";
		}
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		model.addAttribute("student",new User());*/
        User user = use.findOne(body.get("email"));
        if (user != null && user.getEmail().equals(body.get("email"))
                && user.getPassword().equals(body.get("password "))) {
            if (user.getUType().equals("customer")) {
                ModelAndView mv = new ModelAndView();
                mv.setViewName("LoggedInCustomer");
                mv.addObject("user", user);
                return mv;
            } else if (user.getUType().equals("admin")) {
                ModelAndView mv = new ModelAndView();
                mv.setViewName("LoggedInAdmin");
                mv.addObject("user", user);
                return mv;
            }
            else{
                ModelAndView mv = new ModelAndView();
                mv.setViewName("LoggedInStoreOwner");
                mv.addObject("user", user);
                return mv;
            }
        } else {
            ModelAndView mv = new ModelAndView();
            mv.setViewName("customerHome");
            mv.addObject("err", "Your username or password is incorrect");
            return mv;
        }
		//return "/customerHome";
        //return null;
	}

	@RequestMapping("/Register") // @ResponseBody
	public String register(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("password") String pass, @RequestParam("confirmpassword") String conPass,
			@RequestParam("type") String type, HttpServletRequest req) {
		User u = new User(name, email, pass);
		// Optional <User> userObj=u;

		if (use.exists(u.getEmail()) == false)// don't have an account
		{
			User user = new User(name, email, pass);
			if (pass.equals(conPass)) {
				if (type == "customer") {
					req.getSession().setAttribute("custmer", u);
					use.save(user);
					return "customerHomePage";
				} else if (type == "admin") {
					req.getSession().setAttribute("admin", u);
					use.save(user);
					return "adminHomePage";
				} else if (type == "storeOwner") {
					req.getSession().setAttribute("storeOwner", u);
					use.save(user);
					return "storeOwnerHomePage";
				}

			} else {
				System.out.println("try again");

			}
		} else {
			System.out.println("you have an account!");

		}

		return "login";

	}

}
