package com.Hello.study;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Thread thread = new Thread(new TestRunable());
        thread.start();
        System.out.println(thread.getName());
	}

}
