package multhreading;

import java.util.concurrent.*;


public class ThreadPool {

    public static void main(String args[]) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for(int i = 0; i < 5; i++)
        executor.submit(new Work(i));
        executor.shutdown();
        System.out.println("All threads are start");
        executor.awaitTermination(1, TimeUnit.DAYS);
        
    }
}

class Work implements Runnable {

	private int id;


	public Work(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {e.printStackTrace();}
		
		System.out.println("Finished " + id);
	}
}
