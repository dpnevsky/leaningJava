package multhreading;

import java.util.*;

public class SynchronizedTwoLock {
	public static void main (String[] args) {
		new Worker().mainWork();
 }
}


class Worker {
	Random random = new Random();
	
	private List<Integer> list1 = new ArrayList<>(); 
	private List<Integer> list2 = new ArrayList<>();
	
	Object lock1 = new Object();
	Object lock2 = new Object();
	
	public void addnumber1() {
		synchronized (lock1) {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace(); }
		
		list1.add(random.nextInt(100)); }
	}
	
	public void addnumber2() {
		synchronized (lock2) {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace(); }
		
		list2.add(random.nextInt(100));}
	}
		
		
	
	
	public void work() {
		
		for (int i = 0; i < 1000; i++) {
			addnumber1();
			addnumber2();
			}
	}

	public void mainWork () {
	
	long start = System.currentTimeMillis();
	
	Thread thread1 = new Thread(new Runnable() {
		public void run () {
			work();
		}
	});
	
	Thread thread2 = new Thread(new Runnable() {
		public void run () {
			work();
		}
	});
	
	thread1.start();
	thread2.start();
	
	try {
		thread1.join();
		thread2.join();
	} catch (InterruptedException e) {
		e.printStackTrace(); }
	
	long end = System.currentTimeMillis();
	
	System.out.println(end - start);
	System.out.println("List1 " + list1.size());
	System.out.println("List2 " + list2.size());
	}
}
	
	
	
