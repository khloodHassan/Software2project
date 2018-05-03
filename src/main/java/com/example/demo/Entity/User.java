package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name="user")
public class User implements Serializable{
    @Column(name = "email")
    @Id
    private String email;
    private String userName;
    private String password;
    private String confirm;
    private String type;
    private String storeOwnerEmail;

    private static final long serialVersionUID=1L;
    public User(){}

    public User(String name,String email,String pass)
    {
    	this.userName=name;
        this.email=email;
        this.password=pass;
    }

    public User(String email, String userName, String password, String confirm, String type) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.confirm = confirm;
        this.type = type;
    }
    public User(String email, String userName, String password, String confirm, String type,String storeOwner) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.confirm = confirm;
        this.type = type;
        storeOwnerEmail=storeOwner;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getType() {
        return type;
    }

    public String getStoreOwnerEmail() {
        return storeOwnerEmail;
    }

    public void setStoreOwnerEmail(String storeOwnerEmail) {
        this.storeOwnerEmail = storeOwnerEmail;
    }
}
