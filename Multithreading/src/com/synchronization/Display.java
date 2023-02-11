package com.synchronization;

public class Display {

	public synchronized void wish(String name) {
		System.out.println("Good morning ");
		try {
			Thread.sleep(200);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name);
	}
}
