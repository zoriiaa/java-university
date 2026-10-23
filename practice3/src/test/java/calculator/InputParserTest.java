package calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputParserTest {

    @Test
    void parsesValidNumber() {
        assertEquals(12.5, InputParser.parseNumber("12.5"), 1e-9);
    }

    @Test
    void parsesNumberWithComma() {
        assertEquals(12.5, InputParser.parseNumber("12,5"), 1e-9);
    }

    @Test
    void stringInsteadOfNumberThrowsInvalidInputException() {
        assertThrows(InvalidInputException.class, () -> InputParser.parseNumber("abc"));
    }

    @Test
    void blankInputThrowsInvalidInputException() {
        assertThrows(InvalidInputException.class, () -> InputParser.parseNumber("   "));
    }

    @Test
    void nullInputThrowsInvalidInputException() {
        assertThrows(InvalidInputException.class, () -> InputParser.parseNumber(null));
    }
}
