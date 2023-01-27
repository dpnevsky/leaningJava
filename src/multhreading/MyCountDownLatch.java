package multhreading;

import java.util.concurrent.*;

public class MyCountDownLatch {
	public static void main (String[] args) throws InterruptedException {
	CountDownLatch latch = new CountDownLatch(3);
	ExecutorService executor = Executors.newFixedThreadPool(3);
	executor.submit(new Worker2(latch));
	executor.shutdown();
	executor.awaitTermination(1, TimeUnit.DAYS);
   
	System.out.println("First branch");
	latch.await();
	System.out.println("Second branch"); 
	System.out.println("Threed branch");
	
	}
		
}

class Worker2 implements Runnable {
	CountDownLatch latch;

	public Worker2(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
		latch.countDown();}
		System.out.println("Latch open");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}


	
}

