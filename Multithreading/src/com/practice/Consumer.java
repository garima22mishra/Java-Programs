package com.practice;

public class Consumer extends Thread {

	Company c;

	public Consumer(Company _c) {
		this.c = _c;
	}

	public void run() {

		while (true) {
			try {
				this.c.consume_item();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
