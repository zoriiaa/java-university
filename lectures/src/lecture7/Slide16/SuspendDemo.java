package lecture7.Slide16;

class MyThread implements Runnable {
    Thread thrd;
    private boolean suspended = false;
    private boolean stopped = false;

    MyThread(String name) {
        thrd = new Thread(this, name);
    }

    public static MyThread createAndStart(String name) {
        MyThread myThread = new MyThread(name);
        myThread.thrd.start();
        return myThread;
    }

    public synchronized void mysuspend() {
        suspended = true;
    }

    public synchronized void myresume() {
        suspended = false;
        notify();
    }

    public synchronized void mystop() {
        stopped = true;
        suspended = false;
        notify();
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i < 100; i++) {
                synchronized (this) {
                    while (suspended) {
                        wait();
                    }
                    if (stopped) break;
                }
                System.out.print(i + " ");
                Thread.sleep(250);
            }
        } catch (InterruptedException e) {
            System.out.println("Потік перервано");
        }
    }
}

public class SuspendDemo {
    public static void main(String[] args) {
        MyThread mt = MyThread.createAndStart("Мій потік");

        try {
            Thread.sleep(1000);
            mt.mysuspend();
            System.out.println("\nПотік призупинено");
            Thread.sleep(1000);
            mt.myresume();
            System.out.println("Потік відновлено");
            Thread.sleep(1000);
            mt.mysuspend();
            System.out.println("\nПотік призупинено");
            Thread.sleep(1000);
            mt.myresume();
            System.out.println("Потік відновлено");
            Thread.sleep(1000);
            mt.mystop();
            mt.thrd.join();
        } catch (InterruptedException e) {
            System.out.println("Головний потік перервано");
        }

        System.out.println("\nГоловний потік завершено");
    }
}
