package multithreading;

public class CreateThreads {
    public static void main(String[] args) {
        // Using Thread class
        MyThreadd thread1 = new MyThreadd();
        thread1.start();

        // Using Runnable interface
        Runnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable);
        thread2.start();
    }
}

class MyThreadd extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + " is executing run() in MyThread");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + " is executing run() in MyRunnable");
    }
}
