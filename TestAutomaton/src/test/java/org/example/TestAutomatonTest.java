package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAutomatonTest {

    private TestAutomaton automaton;

    @BeforeEach
    void setUp() {
        automaton = new TestAutomaton();
    }

    @ParameterizedTest(name = "\"{0}\" -> {1}")
    @CsvSource({
            "'', S",
            "abc, S",
            "abcT, 1",
            "abcTE, 2",
            "abcTES, 3",
            "abcTEST, F",
            "TEST, F",
            "abcTESTabc, F",
            "TESTEST, F",
            "TESTT, F",
            "TEX, S",
            "TET, S",
            "TESS, S",
            "test, S",
            "TEs, S",
            "T E S T, 1",
            "TTEST, F",
            "TTTEST, F",
            "TETEST, F",
            "TESTTEST, F"
    })
    void shouldReturnExpectedState(String input, String expected) {
        assertEquals(expected, automaton.run(input).getLabel());
    }
}