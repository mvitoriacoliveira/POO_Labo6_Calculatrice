package Java.calculator.Operation;

import Java.calculator.util.State;
import Java.calculator.format.Formatter;

/**
 * Represents a squared operation in a calculator.
 * It extends the Operator class and implements the execute method.
 * The result is formatted using the provided Formatter.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 * @see Operator
 */
public class Squared extends Operator {

    /**
     * Constructs a Squared object with the given state.
     * @param state The state of the calculator.
     */
    public Squared(State state) {
        super(state);
    }

    /**
     * Executes the squared operation (x^2).
     * If the current input is a valid numeric value, calculates the result and updates the state.
     * Otherwise, sets the current input to "Error" and marks an error in the state.
     */
    @Override
    public void execute() {

        String currentInput = state.getCurrentInput();

        try {
            double input = Double.parseDouble(currentInput);

            double result = Math.pow(input, 2);

            state.setCurrentInput(Formatter.format(result));
        } catch (NumberFormatException e) {
            state.setCurrentInput("Error");
            state.setError(true);
        }
    }
}

