package com.example.demo.Entity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import  org.springframework.*;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.Repository.ProductRep;

@Entity
public class Product {
    @Id
    private String name;
    private String price;
    private String category;
    private String brand; 


   public Product(){}

    public Product(String n,String p,String b,String c) {
        name=n;
        price=p;
        brand=b;
        category=c;
        
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getBrand() {
        return brand;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCatecory(String category) {
        this.category = category;
    }
}
