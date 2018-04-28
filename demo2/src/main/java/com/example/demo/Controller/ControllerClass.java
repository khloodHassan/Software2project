package com.example.demo.Controller;

import com.example.demo.Entity.*;
import com.example.demo.Controller.*;
import com.example.demo.Repository.*;


//import com.couchbase.client.java.repository.Repository;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.User;
import com.example.demo.Repository.ProductRep;
import com.example.demo.Repository.UserRep;

import groovy.util.ConfigBinding;

import java.util.Optional;
import java.applet.Applet;
import java.lang.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.awt.*;
import java.applet.*;

//@Controller
//@EnableJpaRepositories("Repository")
//@EntityScan("Entity")
public class ControllerClass extends Applet{
    @Autowired
    private ProductRep p;
    @Autowired
    private UserRep use;
    
    
    
    
    @GetMapping("/showStatistics")
    public void paint(Graphics g)
	{
        String str_sum = "Sum="+String.valueOf(4524);
        g.drawString(str_sum,100,200);
	}
}









