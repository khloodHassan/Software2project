package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entity.User;

public interface UserRep extends CrudRepository<User,String>{

}
