package lecture7.Threads;

public class CheckThreadStatus {
    public static void main(String[] args) {
        MyThread mt1 = MyThread.createAndStart("Task #1");
        MyThread mt2 = MyThread.createAndStart("Task #2");
        MyThread mt3 = MyThread.createAndStart("Task #3");

        do {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException exc) {
                System.out.println("Головний потік перерваний.");
            }
        } while (mt1.thrd.isAlive() || mt2.thrd.isAlive() || mt3.thrd.isAlive());

        System.out.println("Головний потік завершений.");
    }
}

