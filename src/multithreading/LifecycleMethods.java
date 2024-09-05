package multithreading;

public class LifecycleMethods {
    public static void main(String[] args) throws InterruptedException {
        // Example of start() and run()
        MyThread thread1 = new MyThread();
        thread1.start();
        System.out.println(Thread.currentThread().getId() + " is executing main()");

        // Example of sleep()
        SleepThread thread2 = new SleepThread();
        thread2.start();
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getId() + " is executing main() after sleep()");

        // Example of join()
        JoinThread thread3 = new JoinThread();
        thread3.start();
        thread3.join(); // Waits for thread3 to finish
        System.out.println(Thread.currentThread().getId() + " is executing main() after join()");

        // Example of interrupt()
        InterruptThread thread4 = new InterruptThread();
        thread4.start();
        Thread.sleep(3000);
        thread4.interrupt(); // Requests interruption
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + " is executing run()");
    }
}

class SleepThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getId() + " is going to sleep.");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + " has woken up.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class JoinThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getId() + " has completed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class InterruptThread extends Thread {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getId() + " is running.");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getId() + " was interrupted.");
                return;
            }
        }
    }
}
