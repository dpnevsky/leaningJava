package multhreading;

import java.util.Random;
import java.util.concurrent.*;

public class ProducerCunsumerBlockingQueue {
	static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
	
	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(new Runnable (){
			@Override
			public void run() {
				try {
					producer();
				} catch (Exception e) {e.printStackTrace();}	
			}
		});
		
		Thread thread2 = new Thread(new Runnable (){
			@Override
			public void run() {
				try {
					consumer();
				} catch (Exception e) {e.printStackTrace();}	
			}
		});
		
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
	}
		
		public static void producer() throws InterruptedException{
			while (true) {
				Thread.sleep(10);
				Random random = new Random();
				queue.put(random.nextInt(10));
			}
		}
		
		public static void consumer() throws InterruptedException {
			while (true) {
				Thread.sleep(11);
				System.out.println(queue.take());
				System.out.println("Take the element, queue size is " + queue.size());
				
			}
		}
		}

