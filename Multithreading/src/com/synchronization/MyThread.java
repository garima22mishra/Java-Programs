package com.synchronization;

public class MyThread extends Thread{

	Display d;
	String name;
	
	MyThread(Display _d, String _name){
		this.d = _d;
		this.name = _name;
	}
	
	public void run() {
		d.wish(name);
	}
}
