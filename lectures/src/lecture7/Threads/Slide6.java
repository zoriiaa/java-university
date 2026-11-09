package lecture7.Threads;

class MyTask implements Runnable {
    public void run() {
        System.out.println("Потік " + Thread.currentThread().getName() + " виконує завдання");
    }
}

public class Slide6 {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyTask(), "StudentThread");
        thread.start();
        System.out.println("Ім'я потоку: " + thread.getName());

        MyThread mt = MyThread.createAndStart("StudentThread2");
    }
}

