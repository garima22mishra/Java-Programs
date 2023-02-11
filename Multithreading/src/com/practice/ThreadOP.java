package com.practice;

public class ThreadOP {

	public static void main(String[] args) {
		System.out.println("Program started");
		int x=20, y=30;
		System.out.println("Sum of x="+x+" y="+y+" is= "+(x+y));
		String name = Thread.currentThread().getName();
		System.out.println("Thread Name is = "+name);
		System.out.println("Program ended");
	}
}
