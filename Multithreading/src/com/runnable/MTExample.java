package com.runnable;

public class MTExample implements Runnable {

	public void run() {
		System.out.println("Thread " + Thread.currentThread().getId() + " is running");
	}

	public static void main(String[] args) {
		Thread obj = new Thread(new MTExample());
		obj.start();
	}
}
