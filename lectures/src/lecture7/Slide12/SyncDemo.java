package lecture7.Slide12;

class SyncTask {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class CounterThread extends Thread {
    SyncTask task;

    CounterThread(SyncTask task) {
        this.task = task;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            task.increment();
        }
    }
}

public class SyncDemo {
    public static void main(String[] args) throws InterruptedException {
        SyncTask task = new SyncTask();
        CounterThread t1 = new CounterThread(task);
        CounterThread t2 = new CounterThread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Значення лічильника: " + task.getCount());
    }
}
