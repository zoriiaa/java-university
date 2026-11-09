package lecture7.Slide14;

class Library {
    private int books;

    Library(int totalBooks) {
        books = totalBooks;
    }

    void borrowBook(String student) {
        synchronized (this) {
            if (books > 0) {
                System.out.println(student + " взяв книгу.");
                books--;
            } else {
                System.out.println("Немає книг для " + student);
            }
        }
    }
}

class BorrowThread extends Thread {
    Library library;
    String student;

    BorrowThread(Library library, String student) {
        this.library = library;
        this.student = student;
    }

    public void run() {
        library.borrowBook(student);
    }
}

public class LibraryDemo {
    public static void main(String[] args) throws InterruptedException {
        Library library = new Library(2);

        BorrowThread s1 = new BorrowThread(library, "Студент 1");
        BorrowThread s2 = new BorrowThread(library, "Студент 2");
        BorrowThread s3 = new BorrowThread(library, "Студент 3");
        BorrowThread s4 = new BorrowThread(library, "Студент 4");

        s1.start();
        s2.start();
        s3.start();
        s4.start();

        s1.join();
        s2.join();
        s3.join();
        s4.join();
    }
}


