package com.tcmap.entity;

import java.util.concurrent.Callable;

public class Consumer implements Callable{
    
	@Override
	public Object call() throws Exception {
		Store store = new Store();
		id:for(int i = 0;i < 100;i++) {
			if(store.a <= 0) {
				i--;
				continue id;
			}
		store.rm();
		store.show();
		}
		return "我在消费";
	}
    
}
