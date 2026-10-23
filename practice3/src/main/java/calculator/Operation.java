package calculator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Operation {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String symbol;

    public static Operation fromSymbol(String symbol) {
        String trimmed = symbol == null ? "" : symbol.trim();
        return Arrays.stream(values())
                .filter(operation -> operation.symbol.equals(trimmed))
                .findFirst()
                .orElseThrow(() -> new InvalidInputException(
                        "Невідома операція: '" + trimmed + "'. Доступні: + - * /"));
    }
}
