package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    private static final double DELTA = 1e-9;

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void addReturnsSum() {
        assertEquals(5.0, calculator.add(2, 3), DELTA);
    }

    @Test
    void subtractReturnsDifference() {
        assertEquals(-1.0, calculator.subtract(2, 3), DELTA);
    }

    @Test
    void multiplyReturnsProduct() {
        assertEquals(6.0, calculator.multiply(2, 3), DELTA);
    }

    @Test
    void divideReturnsQuotient() {
        assertEquals(2.5, calculator.divide(5, 2), DELTA);
    }

    @Test
    void divideByZeroThrowsArithmeticException() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }

    @Test
    void nanThrowsInvalidInputException() {
        assertThrows(InvalidInputException.class, () -> calculator.add(Double.NaN, 1));
    }

    @Test
    void infinityThrowsInvalidInputException() {
        assertThrows(InvalidInputException.class,
                () -> calculator.multiply(1, Double.POSITIVE_INFINITY));
    }

    @Test
    void calculateUsesCorrectOperation() {
        assertEquals(8.0, calculator.calculate(Operation.ADD, 5, 3), DELTA);
        assertEquals(2.0, calculator.calculate(Operation.SUBTRACT, 5, 3), DELTA);
        assertEquals(15.0, calculator.calculate(Operation.MULTIPLY, 5, 3), DELTA);
        assertEquals(2.0, calculator.calculate(Operation.DIVIDE, 6, 3), DELTA);
    }
}