package lecture7.Threads;

public class Slide7 {
    public static void main(String[] args) {
        MyThread mt1 = MyThread.createAndStart("Thread #1");
        MyThread mt2 = MyThread.createAndStart("Thread #2");
        MyThread mt3 = MyThread.createAndStart("Thread #3");
    }
}
