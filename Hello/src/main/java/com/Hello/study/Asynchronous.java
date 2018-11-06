package com.Hello.study;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Asynchronous {

	public static void main(String[] args) {
		
		ExecutorService es = Executors.newCachedThreadPool();
		
		Callable<Integer> ctTask = new CUPDTask();
		Callable<Integer> rmTask = new RMTask();
		Future<Integer> rmSubmit = es.submit(rmTask);
		Future<Integer> ctSubmit = es.submit(ctTask);
        es.shutdown();
       System.out.println(Thread.currentThread().getId());
       try {
		Integer integer = rmSubmit.get();
		Integer integer2 = ctSubmit.get();
		System.out.println(integer);
		System.out.println(Thread.currentThread().getId());
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ExecutionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
 

}
class RMTask implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println("creating response Rich media, thread id="+Thread.currentThread().getId());
		Thread.sleep(3000);
		System.out.println("end response Rich media, thread id="+Thread.currentThread().getId());
		return new Integer(3);
	}
	
}

class CUPDTask implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println("creating CUPD msg, thread id="+Thread.currentThread().getId());
		Thread.sleep(8000);
		System.out.println("end response Rich media, thread id="+Thread.currentThread().getId());
		return new Integer(10);
	}
	
}

