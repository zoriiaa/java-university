package lecture7;

class Task implements Runnable {
    public void run() {
        System.out.println("Запуск нового потоку");
    }
}

public class Slide5 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.start();
        System.out.println("Основний потік продовжує роботу");
    }
}
