package com.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MTDemo {

	static class Task implements Runnable{

		@Override
		public void run() {
			System.out.println("Thread "+Thread.currentThread().getName()+" is running");
		}
	}
	
	public static void main(String[] args) {
		// 1. Create a fixed thread pool
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		// 2. Submit the task for execution
		for(int i=0;i<100;i++) {
			service.execute(new Task());
		}
		System.out.println("Thread "+Thread.currentThread().getId()+ " is executed");
	}
}
