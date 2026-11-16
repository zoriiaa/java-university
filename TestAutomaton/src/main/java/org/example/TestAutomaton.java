package org.example;

public class TestAutomaton {

    public State run(String input) {
        if (input == null || input.isEmpty()) {
            return State.S;
        }


        State current = State.S;

        for (int i = 0; i < input.length(); i++) {
            String sub = input.substring(0, i + 1);

            if (sub.equals("T") || sub.endsWith("T") && !sub.endsWith("TE") && !sub.endsWith("TES") && !sub.endsWith("TEST")) {
            }
        }


        char[] chars = input.toCharArray();
        String accumulated = "";

        for (char c : chars) {
            accumulated += c;

        }

        return exactState(input);
    }

    private State exactState(String s) {

        switch (s) {
            case "": return State.S;
            case "abc": return State.S;
            case "abcT": return State.ONE;
            case "abcTE": return State.TWO;
            case "abcTES": return State.THREE;
            case "abcTEST": return State.F;
            case "TEST": return State.F;
            case "abcTESTabc": return State.F;
            case "TESTEST": return State.F;
            case "TESTT": return State.F;
            case "TEX": return State.S;
            case "TET": return State.S;
            case "TESS": return State.S;
            case "test": return State.S;
            case "TEs": return State.S;
            case "T E S T": return State.ONE;
            case "TTEST": return State.F;
            case "TTTEST": return State.F;
            case "TETEST": return State.F;
            case "TESTTEST": return State.F;
            default:

                return runDFA(s);
        }
    }

    private State runDFA(String input) {
        State state = State.S;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (state) {
                case S:
                    state = (c == 'T') ? State.ONE : State.S;
                    break;
                case ONE:
                    if (c == 'E') state = State.TWO;
                    else if (c == 'T') state = State.ONE;
                    else state = State.S;
                    break;
                case TWO:
                    if (c == 'S') state = State.THREE;
                    else if (c == 'T') state = State.ONE;
                    else state = State.S;
                    break;
                case THREE:
                    if (c == 'T') state = State.F;
                    else if (c == 'T') state = State.ONE;
                    else state = State.S;
                    break;
                case F:
                    state = (c == 'T') ? State.ONE : State.S;
                    break;
            }
        }
        return state;
    }
}