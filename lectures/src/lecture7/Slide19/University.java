package lecture7.Slide19;

enum Subject {
    MATHEMATICS, PHYSICS, LITERATURE, HISTORY
}

public class University {
    public static void main(String[] args) {
        Subject[] allSubjects = Subject.values();
        System.out.println("Усі предмети:");
        for (Subject s : allSubjects) {
            System.out.println(s);
        }

        Subject specificSubject = Subject.valueOf("PHYSICS");
        System.out.println("Вибраний предмет: " + specificSubject);
    }
}

