package com.practice;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableExample {

	public static void main(String[] args) {

		ExecutorService service = Executors.newFixedThreadPool(10);
		List<Future<Integer>> allFutures = new LinkedList<>();
		
		System.out.println("Before Task Execution");
		
		try {
			for (int i = 0; i < 100; i++) {
				Future<Integer> future = service.submit(new Task());
				allFutures.add(future);
			}

			System.out.println("Waiting for future values");

			for (int i = 0; i < 100; i++) {
				Future<Integer> future = allFutures.get(i);
				Integer integer = future.get(10, TimeUnit.SECONDS);
				System.out.println("Value = " + integer);
			}
			
			System.out.println("After Task Execution");

		} catch (Exception _ex) {
			System.out.println("Error in Task Execution");
			_ex.printStackTrace();
		}finally {
			service.shutdown();
		}
	}

	static class Task implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
			int result = 1;

			System.out.println("Executing callable task");
			for (int i = 10; i > 0; i--) {
				result *= i;
			}
			return result;
		}

	}
}
