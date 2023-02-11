package com.practice;

public class MyThread implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("MyThread is running.."+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println("Current Thread "+Thread.currentThread().getId()+"is running");
		}
	}
	
	public static void main(String[] args) {
		MyThread thread = new MyThread();
		MyAnotherThread t2 = new MyAnotherThread();
		
		Thread t1 = new Thread(thread);
		String name = t1.getName();
		System.out.println("Thread 1's name : "+name);
		int priority = t1.getPriority();
		System.out.println("Thread 1's default priority "+priority);
		t1.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		
		name = t2.getName();
		System.out.println("Thread 2's name : "+name);
		priority = t2.getPriority();
		System.out.println("Thread 2's default priority "+priority);
		t2.setPriority(Thread.MAX_PRIORITY);
		t2.start();
	}

}
