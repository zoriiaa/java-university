package lecture7.Slide15;

class Printer {
    private boolean isBusy = false;

    synchronized void printDocument(String docName) {
        while (isBusy) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Очікування перерване");
            }
        }
        isBusy = true;
        System.out.println("Друк документу: " + docName);
        isBusy = false;
        notifyAll();
    }
}

class PrintThread extends Thread {
    Printer printer;
    String doc;

    PrintThread(Printer printer, String doc) {
        this.printer = printer;
        this.doc = doc;
    }

    public void run() {
        printer.printDocument(doc);
    }
}

public class PrinterDemo {
    public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer();

        PrintThread p1 = new PrintThread(printer, "Реферат.docx");
        PrintThread p2 = new PrintThread(printer, "Звіт.pdf");
        PrintThread p3 = new PrintThread(printer, "Лабораторна.txt");

        p1.start();
        p2.start();
        p3.start();

        p1.join();
        p2.join();
        p3.join();
    }
}

