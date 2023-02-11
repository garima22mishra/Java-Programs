package com.practice;

public class MyAnotherThread extends Thread{
	public void run() {
		for(int i=10;i>0;i--) {
			System.out.println("MyAnotherThread is running.."+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
