package com.comparable;

import java.util.Arrays;

public class Employee implements Comparable<Employee> {

	private Integer age;

	public Employee(Integer age) {
		this.age = age;
	}

	public int compareTo(Employee e) {
		return this.age.compareTo(e.age);
	}

	public String toString() {
		return "age = " + age;
	}

	public static void main(String[] args) {
		Employee[] e = new Employee[3];
		e[0] = new Employee(23);
		e[1] = new Employee(45);
		e[2] = new Employee(12);

		Arrays.sort(e);

		for (Employee a : e) {
			System.out.println(a);
		}

	}

}
