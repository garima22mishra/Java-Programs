package com.practice;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ParallelProcessing {
	static int i = 0;

	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(10,
        new ThreadFactory() {
			 public Thread newThread(Runnable r) {
	                Thread t = Executors.defaultThreadFactory().newThread(r);
	                t.setDaemon(true);
	                return t;
	            }
        });

		CountDownLatch cd = new CountDownLatch(10);
		LinkedList<String> result = new LinkedList<>();
		List<Future<?>> tasks = new LinkedList<>();

		for (int i = 0; i < 10; i++) {
			Login task = new Login(i, cd, result, exec);
			tasks.add(exec.submit(task));
		}

		try {

			cd.await(10000, TimeUnit.MILLISECONDS);
			
			exec.shutdown();
			
			boolean isLoggedIn = false;

			for (String res : result) {

				isLoggedIn = Boolean.parseBoolean(res);

				if (isLoggedIn) {
					break;
				}
			}
			System.out.println(result.size() + "==>" + isLoggedIn);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static class Login implements Runnable {

		int threadnumber;
		CountDownLatch cd;
		List<String> result;
		ExecutorService exec;

		public Login(int threadnumber, CountDownLatch cd, List<String> result, ExecutorService exec) {
			this.cd = cd;
			this.threadnumber = threadnumber;
			this.result = result;
			this.exec = exec;
		}

		@Override
		public void run() {
			
			if(this.cd.getCount() <= 0) {
				System.out.println("returning");
				return;
			}
			
			System.out.println("Executing thread" + threadnumber);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
			}
			// abort on 5
			if (this.threadnumber == 5) {
				System.out.println("Login successful! aborting other threads.");
				result.add("true");
				while (cd.getCount() > 0) {
					cd.countDown();
				}

				//System.out.println("After countdown:" + cd.getCount());
			} else {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					 return;
				}
				result.add("false");
			}

		}
	}
}
