package com.example.demo.Repository;

import com.example.demo.Entity.Brand;
import com.example.demo.Entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface BrandRep extends CrudRepository<Brand,String> {
}
