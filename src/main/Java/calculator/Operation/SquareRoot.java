package Java.calculator.Operation;

import Java.calculator.util.State;
import Java.calculator.format.Formatter;

/**
 * The SquareRoot class represents the square root operation (√x).
 * It extends the Operator class and implements the execute method.
 * The result is formatted using the provided Formatter.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 * @see Operator
 */
public class SquareRoot extends Operator {

    /**
     * Constructs a SquareRoot object with the given state.
     *
     * @param s The state of the calculator.
     */
    public SquareRoot(State s) {
        super(s);
    }

    /**
     * Executes the square root operation (√x).
     * If the current input is non-negative, calculates the result and updates the state.
     * Otherwise, throws an ArithmeticException with the message "Cannot take the square root of a negative number."
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
