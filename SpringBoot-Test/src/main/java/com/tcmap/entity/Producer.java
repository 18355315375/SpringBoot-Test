package com.tcmap.entity;

import java.util.concurrent.Callable;

public class Producer implements Callable{

	@Override
	public Object call() throws Exception {
		Store store = new Store();
		for(int i = 0;i < 100;i++) {
		store.add();
		store.show();
		}
		return "我在生产";
	}
      
}
