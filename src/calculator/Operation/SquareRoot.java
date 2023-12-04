package calculator.Operation;

import calculator.State;
import calculator.Formatter;

/**
 * The {@code SquareRoot} class represents the square root operation (√x).
 * It extends the {@code Operator} class and implements the {@code execute} method.
 * The result is formatted using the provided {@code Formatter}.
 */
public class SquareRoot extends Operator {

    /**
     * Constructs a {@code SquareRoot} object with the given state.
     *
     * @param s The state of the calculator.
     */
    public SquareRoot(State s) {
        super(s);
    }

    /**
     * Executes the square root operation (√x).
     * If the current input is non-negative, calculates the result and updates the state.
     * Otherwise, throws an {@code ArithmeticException} with the message "Cannot take the square root of a negative number."
     *
     * @throws ArithmeticException If attempting to take the square root of a negative number.
     */
    @Override
    public void execute() {

        String currentInput = state.getCurrentInput();

        try {
            double input = Double.parseDouble(currentInput);
            if (input >= 0) {
                double result = Math.sqrt(input);
                state.setCurrentInput(Formatter.format(result));
            } else {
                state.setCurrentInput("Error: negative number");
                state.setError(true);
            }
        } catch (NumberFormatException e) {
            state.setCurrentInput("Error");
        }
    }
}
