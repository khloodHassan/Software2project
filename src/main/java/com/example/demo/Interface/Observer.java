package com.example.demo.Interface;

import com.example.demo.Controller.StoreController;
import com.example.demo.Entity.Store;

public abstract class Observer {
	StoreController controller=new StoreController();
	public abstract void update(Store store);
}
