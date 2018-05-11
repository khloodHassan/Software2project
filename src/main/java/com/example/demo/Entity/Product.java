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
    private Double price;
    private String category;
    private String brand;
    private int quantity;
    private int numOfViews;
    private String store;
    //private boolean isFirstTime;

   public Product(){
       //isFirstTime=true;
   }

    public Product(String n,Double p,String b,String c) {
        name=n;
        price=p;
        brand=b;
        category=c;
        numOfViews=0;
        //isFirstTime=true;
    }
    public Product(String n,Double p,String b,String c,int quantity) {
        name=n;
        price=p;
        brand=b;
        category=c;
        this.quantity=quantity;
        numOfViews=0;
        //isFirstTime=true;
    }


    public Product(String n,Double p,String b,String c,int quantity,String store) {
        name=n;
        price=p;
        brand=b;
        category=c;
        this.quantity=quantity;
        numOfViews=0;
        this.store=store;
        //isFirstTime=true;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
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

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCatecory(String category) {
        this.category = category;
    }


    public int getNumOfViews() {
        return numOfViews;
    }

    public void setNumOfViews(int numOfViews) {
        this.numOfViews = numOfViews;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }
/*
    public void setFirstTime(boolean firstTime) {
        isFirstTime = firstTime;
    }

    public boolean isFirstTime() {
        return isFirstTime;
    }*/
}

