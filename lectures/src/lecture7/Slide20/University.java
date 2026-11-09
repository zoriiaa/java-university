package lecture7.Slide20;

enum Subject {
    MATHEMATICS(5), PHYSICS(4), LITERATURE(3), HISTORY(2);

    private int complexity;

    Subject(int complexity) {
        this.complexity = complexity;
    }

    public int getComplexity() {
        return complexity;
    }
}

public class University {
    public static void main(String[] args) {
        for (Subject subject : Subject.values()) {
            System.out.println(subject + " has complexity level: " + subject.getComplexity());
        }
    }
}

