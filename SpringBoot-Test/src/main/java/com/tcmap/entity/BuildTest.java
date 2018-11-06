package com.tcmap.entity;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


public class BuildTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
//         BuilderDirector builderDirector = new BuilderDirector(new BuilderA());
//         builderDirector.build().show();
		FutureTask fTask = new FutureTask<>(new Producer());
		FutureTask Task = new FutureTask<>(new Consumer());
		new Thread(Task).start();
		new Thread(fTask).start();
		System.out.println(fTask.get());
		System.out.println(Task.get());
	}

}
