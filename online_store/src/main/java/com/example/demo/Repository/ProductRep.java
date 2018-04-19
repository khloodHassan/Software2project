package com.example.demo.Repository;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.User;

import org.springframework.data.repository.CrudRepository;

public interface ProductRep extends CrudRepository<Product,String> {


}
