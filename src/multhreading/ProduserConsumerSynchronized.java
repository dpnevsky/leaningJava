package multhreading;

import java.util.*;


public class ProduserConsumerSynchronized {
	public static Queue<Integer> queue = new LinkedList<>();
	static Object lock = new Object();
	

	public static void main(String[] args) throws InterruptedException {
		
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					produser();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} 
		});
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					consumer();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			} 
		});
		
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
		
		

	}




public static void produser  () throws InterruptedException {
	Random random = new Random();
	synchronized (lock) {
		while (true) {
			while(queue.size() == 10) {
				lock.wait();
				}
			queue.offer(random.nextInt(10));
			lock.notify();
			}
		}
	}

public static void consumer() throws InterruptedException {
	synchronized (lock) {
		while (true) {
			while (queue.size() == 0) {
				lock.wait();
			}
				Thread.sleep(100);
				System.out.println(queue.poll());
				System.out.println("Take the element, queue size is " + queue.size());
				lock.notify();
			
		}
	}

	
	
	
		
	}

}
