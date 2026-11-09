package slide3;

public class Slide3 {
    public static void main(String[] args) {
        int credits = 30;
        String status;

        switch (credits) {
            case 30 -> status = "Відмінник";
            case 20 -> status = "Добре";
            case 10 -> status = "Задовільно";
            default -> status = "Потребує додаткового навчання";
        }

        System.out.println("Статус студента: " + status);
    }
}
