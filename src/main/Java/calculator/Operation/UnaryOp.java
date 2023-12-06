
package Java.calculator.Operation;

import Java.calculator.format.Formatter;
import Java.calculator.util.State;

/**
 * Represents a unary operation in a calculator.
 * This class extends the Operator class and implements the execute method.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 * @see Operator
 */
public class UnaryOp extends Operator {
    /**
     * Constructs a UnaryOp object with the given state.
     * @param s The state of the calculator.
     */
    public UnaryOp(State s) {
        super(s);
    }

    /**
     * Executes the unary operation (-x).
     * Retrieves the current input from the state, calculates the result, and updates the state.
     */
    @Override
    public void execute() {
        double input = Double.parseDouble(state.getCurrentInput());

        double result = -input;

        String formattedResult = Formatter.format(result);
        state.setCurrentInput(formattedResult);

    }
}
