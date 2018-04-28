package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Store {
	@Id
	public Integer id;
	private String name;
	private String location;
	private String address;
	private String type;
	
	public Store() {}
	
	public Store(String name,String location,String address,String type)
	{
		this.name=name;
		this.location=location;
		this.address=address;
		this.type=type;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public void setLocation(String location)
	{
		this.location=location;
	}
	
	public void setAddress(String address)
	{
		this.address=address;
	}
	
	public void setType(String type)
	{
		this.type=type;
	}
	
	public String getName()
	{
		return name;
	}
	public String getLocation()
	{
		return location;
	}
	
	public String getAddress()
	{
		return address;
	}
	public String getType()
	{
		return type;
	}
}
