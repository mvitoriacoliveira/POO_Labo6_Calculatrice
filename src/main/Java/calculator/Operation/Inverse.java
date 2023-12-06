
package Java.calculator.Operation;

import Java.calculator.util.State;
import Java.calculator.format.Formatter;

/**
 * The Inverse class represents the operation 1/x in a calculator.
 * This class extends the Operator class and implements the execute method.
 * The result is formatted using the provided Formatter.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 * @see Operator
 */
public class Inverse extends Operator {

    /**
     * Constructs an Inverse object with the given state.
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
                state.setError(true);
            }
        } catch (NumberFormatException e) {
            state.setCurrentInput("Error");
            state.setError(true);
        }

    }
}

