
package calculator.Operation;

import calculator.State;
import calculator.Formatter;


/**
 * The {@code Inverse} class represents the operation 1/x.
 * It extends the {@code Operator} class and implements the {@code execute} method.
 * The result is formatted using the provided {@code Formatter}.
 */
public class Inverse extends Operator {

    /**
     * Constructs an {@code Inverse} object with the given state.
     *
     * @param s The state of the calculator.
     */
    public Inverse(State s){
        super(s);
    }

    /**
     * Executes the inverse operation (1/x).
     * If the current input is not zero, calculates the result and updates the state.
     * Otherwise, throws an {@code ArithmeticException} with the message "Cannot divide by zero."
     *
     * @throws ArithmeticException If attempting to divide by zero.
     */
    @Override
    public void execute() {
        String currentInput = state.getCurrentInput();

        try {
            double input = Double.parseDouble(currentInput);
            if (input != 0) {
                double result = 1 / input;
                state.setCurrentInput(Formatter.format(result));
            } else {
                state.setCurrentInput("Infinty");
            }
        } catch (NumberFormatException e) {
            state.setCurrentInput("Error");
        }

    }
}

