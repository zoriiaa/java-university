package calculator;

public class InputParser {

    private InputParser() {
    }

    public static double parseNumber(String input) {
        if (input == null || input.isBlank()) {
            throw new InvalidInputException("Порожнє значення замість числа");
        }
        try {
            return Double.parseDouble(input.trim().replace(',', '.'));
        } catch (NumberFormatException e) {
            throw new InvalidInputException("'" + input.trim() + "' не є числом", e);
        }
    }
}
