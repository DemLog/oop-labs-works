package site.dlsky.lab02;

import java.util.ArrayList;
import java.util.List;

public class Solver {
    private final String digits;
    private final List<String> expressions;

    public Solver(String digits) {
        this.digits = digits;
        expressions = new ArrayList<>();
    }

    public void solve() {
        generateExpressions("", digits.charAt(0), digits.substring(1));
        Calculator calculator = new Calculator();
        for (String expression : expressions) {
            if (calculator.calculate(expression) == 100) {
                System.out.println(expression + "=100");
            }
        }
    }

    private void generateExpressions(String expressionSoFar, char digit, String remainingDigits) {
        if (remainingDigits.length() == 0) {
            expressions.add(expressionSoFar + digit);
        } else {
            generateExpressions(expressionSoFar + digit + "+", remainingDigits.charAt(0), remainingDigits.substring(1));
            generateExpressions(expressionSoFar + digit + "-", remainingDigits.charAt(0), remainingDigits.substring(1));
            generateExpressions(expressionSoFar + digit + "*", remainingDigits.charAt(0), remainingDigits.substring(1));
            generateExpressions(expressionSoFar + digit + "/", remainingDigits.charAt(0), remainingDigits.substring(1));
            generateExpressions(expressionSoFar + digit, remainingDigits.charAt(0), remainingDigits.substring(1));
        }
    }
}
