package com.comparable;

import java.util.Arrays;

public class Pair implements Comparable<Pair>{
	String x;
	Integer y;
	
	public Pair(String x, Integer y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "("+x+","+y+")";
	}

	@Override
	public int compareTo(Pair a) {
		if(this.x.compareTo(a.x)!=0)
			return this.x.compareTo(a.x);
		
		return this.y.compareTo(a.y);
	}
	
	public static void main(String[] args) {
		Pair[] arr = new Pair[4];
		
		arr[0] = new Pair("abc" , 2);
		arr[1] = new Pair("a" , 7);
		arr[2] = new Pair("abc" , 1);
		arr[3] = new Pair("bc" , 4);

		Arrays.sort(arr);
		
		for(Pair a:arr) {
			System.out.println(a);
		}
	}

}
