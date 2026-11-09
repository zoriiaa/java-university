package lecture7.Threads;

public class JoinExample {
    public static void main(String[] args) {
        MyThread mt1 = MyThread.createAndStart("Task #1");
        MyThread mt2 = MyThread.createAndStart("Task #2");
        MyThread mt3 = MyThread.createAndStart("Task #3");

        try {
            mt1.thrd.join();
            System.out.println("Task #1 приєднано.");
            mt2.thrd.join();
            System.out.println("Task #2 приєднано.");
            mt3.thrd.join();
            System.out.println("Task #3 приєднано.");
        } catch (InterruptedException exc) {
            System.out.println("Головний потік перерваний.");
        }

        System.out.println("Головний потік завершений.");
    }
}
