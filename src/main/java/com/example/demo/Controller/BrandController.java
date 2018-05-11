package com.example.demo.Controller;

import com.example.demo.Entity.Brand;
import com.example.demo.Entity.Product;
import com.example.demo.Repository.BrandRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BrandController {
    @Autowired
    BrandRep brandRepository;

    @GetMapping("/addBrand")
    public String add(Model model)
    {
        model.addAttribute("brand",new Brand());
        return "addBrand";
    }

    @GetMapping("addBrandInDB")
    public String added(Model model, @ModelAttribute Brand brand, HttpServletRequest request)
    {
        if(brand.getName()==""||brand.getCategory()=="")
        {
            model.addAttribute("err","please enter the information again");
            add(model);
            System.out.println("empty");
            return "/addBrand";
        }
        request.getSession().getAttribute("admin");
        if(brandRepository.findOne(brand.getName())==null)
        {
            brandRepository.save(brand);
            System.out.println("saved");
        }
        else {
            System.out.println("already exists");
            model.addAttribute("err","the brand already exists!!");
            add(model);
            return "addBrand";
        }
        return "addBrandInDB";
    }

    @GetMapping("show-all-brands")
    public String show(Model model)
    {
        Iterable<Brand> brandIteratable=brandRepository.findAll();
        List<Brand> brands=new ArrayList<Brand>();
        for(Brand brand:brandIteratable)
        {
            brands.add(brand);
        }
        model.addAttribute("brand",brands);
        return "show-all-brands";
    }
}
