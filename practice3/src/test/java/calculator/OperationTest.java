package calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OperationTest {

    @Test
    void findsOperationBySymbol() {
        assertEquals(Operation.ADD, Operation.fromSymbol("+"));
        assertEquals(Operation.DIVIDE, Operation.fromSymbol(" / "));
    }

    @Test
    void unknownSymbolThrowsInvalidInputException() {
        assertThrows(InvalidInputException.class, () -> Operation.fromSymbol("%"));
    }

    @Test
    void nullSymbolThrowsInvalidInputException() {
        assertThrows(InvalidInputException.class, () -> Operation.fromSymbol(null));
    }
}
