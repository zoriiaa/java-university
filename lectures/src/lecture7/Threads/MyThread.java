package lecture7.Threads;

class MyThread implements Runnable {
    Thread thrd;
    String threadName;

    MyThread(String name) {
        threadName = name;
        thrd = new Thread(this, name);
        System.out.println("Поток " + threadName + " створено.");
    }

    public static MyThread createAndStart(String name) {
        MyThread myThread = new MyThread(name);
        myThread.thrd.start();
        return myThread;
    }

    @Override
    public void run() {
        System.out.println("Поток " + threadName + " запущено.");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("В потоці " + threadName + " значення count = " + count);
            }
        } catch (InterruptedException exc) {
            System.out.println(threadName + " перервано.");
        }
        System.out.println("Поток " + threadName + " завершено.");
    }
}
