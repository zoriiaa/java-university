package lecture7.Slide21;

enum Subject {
    MATHEMATICS, PHYSICS, LITERATURE, HISTORY
}

public class University {
    public static void main(String[] args) {
        for (Subject subject : Subject.values()) {
            System.out.println(subject + " " + subject.ordinal());
        }

        Subject subject1 = Subject.MATHEMATICS;
        Subject subject2 = Subject.PHYSICS;

        if (subject1.compareTo(subject2) < 0) {
            System.out.println(subject1 + " перед " + subject2);
        } else if (subject1.compareTo(subject2) > 0) {
            System.out.println(subject1 + " після " + subject2);
        } else {
            System.out.println(subject1 + " дорівнює " + subject2);
        }
    }
}

