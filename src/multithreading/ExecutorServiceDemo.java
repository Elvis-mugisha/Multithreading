package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            Runnable task = new Task("Task " + i);
            executor.execute(task);
        }

        executor.shutdown();
    }
}

class Task implements Runnable {
    private String message;

    public Task(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + " is executing " + message);
    }
}
