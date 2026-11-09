package lecture7;

public class MethodBoxing {
    static void processStudentID(Integer id) {
        System.out.println("Оброблено студентський ID: " + id);
    }

    static int getBonusPoints() {
        return 5;
    }

    static Integer calculateFinalGrade() {
        return 95;
    }

    public static void main(String[] args) {
        processStudentID(12345);

        int bonus = getBonusPoints();
        System.out.println("Бонусні бали: " + bonus);

        int finalGrade = calculateFinalGrade();
        System.out.println("Остаточна оцінка студента: " + finalGrade);
    }
}

