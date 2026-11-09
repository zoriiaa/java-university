package lecture7.Slide18;

enum Subject {
    MATHEMATICS, PHYSICS, PROGRAMMING, CHEMISTRY
}

public class University {
    public static void main(String[] args) {
        Subject currentSubject = Subject.MATHEMATICS;

        switch (currentSubject) {
            case MATHEMATICS:
                System.out.println("Math lesson in progress.");
                break;
            case PHYSICS:
                System.out.println("Physics lesson in progress.");
                break;
            case PROGRAMMING:
                System.out.println("PROGRAMMING lesson in progress.");
                break;
            case CHEMISTRY:
                System.out.println("CHEMISTRY lesson in progress.");
                break;
        }
    }
}

