package lecture7;

public class ExpressionExample {
    public static void main(String[] args) {
        Integer coursePoints = 90;
        int bonus = 10;
        coursePoints += bonus;
        System.out.println("Загальна кількість балів курсу: " + coursePoints);

        Integer gradeLevel = 3;
        switch (gradeLevel) {
            case 1: System.out.println("Перший курс"); break;
            case 2: System.out.println("Другий курс"); break;
            case 3: System.out.println("Третій курс"); break;
            default: System.out.println("Курс не визначено");
        }
    }
}

