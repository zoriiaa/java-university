package calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        try (Scanner scanner = new Scanner(System.in)) {
            String answer;
            do {
                processRequest(scanner, calculator);
                System.out.print("Продовжити? (y/n): ");
                answer = scanner.nextLine().trim();
            } while (answer.equalsIgnoreCase("y"));
        }
    }

    private static void processRequest(Scanner scanner, Calculator calculator) {
        try {
            System.out.print("Введіть перше число: ");
            double a = InputParser.parseNumber(scanner.nextLine());

            System.out.print("Введіть друге число: ");
            double b = InputParser.parseNumber(scanner.nextLine());

            System.out.print("Введіть операцію (+, -, *, /): ");
            Operation operation = Operation.fromSymbol(scanner.nextLine());

            double result = calculator.calculate(operation, a, b);
            System.out.println("Результат: " + result);
        } catch (InvalidInputException e) {
            System.out.println("Некоректні дані: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Помилка обчислення: " + e.getMessage());
        } finally {
            System.out.println("Обробку запиту завершено.");
        }
    }
}
