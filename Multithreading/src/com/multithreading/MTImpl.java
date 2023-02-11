package com.multithreading;

public class MTImpl {

	public static void main(String[] args) {
		for(int i=0;i<8;i++) {
			MTDemo obj = new MTDemo();
			obj.start();
		}

	}

}
