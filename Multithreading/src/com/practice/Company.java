package com.practice;

public class Company {

	private int n;
	
	/**
	 * flag = true : consume_item
	 * flag = false : produce_item
	 */
	boolean flag = false;

	// setter
	// produce item only when flag = false
	synchronized public void produce_item(int _n) throws InterruptedException {
		if(flag) {
			wait();
		}
		flag = true;
		notify();
		
		this.n = _n;
		System.out.println("Produced item : " + n);
	}

	// getter
	// consume item only when flag = true
	synchronized public int consume_item() throws InterruptedException {
		if(!flag) {
			wait();
		}
		System.out.println("Consumed item : " + this.n);
		flag = false;
		notify();
		return n;
	}
}
