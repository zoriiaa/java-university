package lecture7.Slide11;

class Priority implements Runnable {
    int count;
    Thread thrd;
    static volatile boolean stop = false;
    static String currentName;

    Priority(String name) {
        thrd = new Thread(this, name);
        count = 0;
        currentName = name;
    }

    public void run() {
        System.out.println(thrd.getName() + " запущено.");
        do {
            count++;
            if (currentName.compareTo(thrd.getName()) != 0) {
                currentName = thrd.getName();
                System.out.println("У потоці " + currentName);
            }
        } while (stop == false && count < 10000000);
        stop = true;
        System.out.println(thrd.getName() + " завершено.");
    }
}

public class PriorityDemo {
    public static void main(String[] args) {
        Priority mt1 = new Priority("Високий пріоритет");
        Priority mt2 = new Priority("Низький пріоритет");

        mt1.thrd.setPriority(Thread.NORM_PRIORITY + 2);
        mt2.thrd.setPriority(Thread.NORM_PRIORITY - 2);

        mt1.thrd.start();
        mt2.thrd.start();

        try {
            mt1.thrd.join();
            mt2.thrd.join();
        } catch (InterruptedException exc) {
            System.out.println("Головний потік перервано.");
        }

        System.out.println("Потік з високим пріоритетом нарахував " + mt1.count);
        System.out.println("Потік з низьким пріоритетом нарахував " + mt2.count);
    }
}

