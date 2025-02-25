package MultiThreadModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//
public class ExecutorServiceDemo {
    protected volatile boolean done = false;

    Runnable r = () -> {
        System.out.println("is started.");
        while (!done) {
            System.out.println("is running...");
            try {
                Thread.sleep(720);
            } catch (InterruptedException e) {

            }
        }
        System.out.println("completed.");
    };

    public void shutDown() {
        System.out.println("!");
        done = true;
    }

    public void execute() throws InterruptedException {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        pool.submit(r);
        Thread.sleep(1000*5);
        shutDown();
        pool.shutdown();
        pool.awaitTermination(3, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws InterruptedException {
        new ExecutorServiceDemo().execute();
    }


}
