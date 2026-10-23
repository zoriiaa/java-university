package calculator;

public class Calculator {

    public double add(double a, double b) {
        validate(a, b);
        return a + b;
    }

    public double subtract(double a, double b) {
        validate(a, b);
        return a - b;
    }

    public double multiply(double a, double b) {
        validate(a, b);
        return a * b;
    }

    public double divide(double a, double b) {
        validate(a, b);
        if (b == 0) {
            throw new ArithmeticException("Ділення на нуль неможливе");
        }
        return a / b;
    }

    public double calculate(Operation operation, double a, double b) {
        return switch (operation) {
            case ADD -> add(a, b);
            case SUBTRACT -> subtract(a, b);
            case MULTIPLY -> multiply(a, b);
            case DIVIDE -> divide(a, b);
        };
    }

    private void validate(double a, double b) {
        if (!Double.isFinite(a) || !Double.isFinite(b)) {
            throw new InvalidInputException("Числа мають бути скінченними (не NaN і не Infinity)");
        }
    }
}
