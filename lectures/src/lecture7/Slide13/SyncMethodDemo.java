package lecture7.Slide13;

class SharedResource {
    private int value;

    synchronized int updateResource(int[] nums) {
        value = 0;
        for (int num : nums) {
            value += num;
            System.out.println("Проміжне значення в потоці " +
                    Thread.currentThread().getName() + " = " + value);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Потік перерваний.");
            }
        }
        return value;
    }
}

class SumThread implements Runnable {
    Thread thrd;
    static SharedResource res = new SharedResource();
    int[] a;
    int answer;

    SumThread(String name, int[] nums) {
        thrd = new Thread(this, name);
        a = nums;
        thrd.start();
    }

    public void run() {
        System.out.println(thrd.getName() + " запущено.");
        answer = res.updateResource(a);
        System.out.println("Сума для " + thrd.getName() + " дорівнює " + answer);
        System.out.println(thrd.getName() + " завершено.");
    }
}

public class SyncMethodDemo {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        SumThread mt1 = new SumThread("Потік #1", nums);
        SumThread mt2 = new SumThread("Потік #2", nums);

        try {
            mt1.thrd.join();
            mt2.thrd.join();
        } catch (InterruptedException exc) {
            System.out.println("Головний потік перервано.");
        }
    }
}


