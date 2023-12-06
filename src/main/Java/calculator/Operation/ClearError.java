package Java.calculator.Operation;

import Java.calculator.util.State;

/**
 * Represents the clear operator in a calculator.
 * This class extends the Operator class and is designed to clear the current state and errors.
 * It resets the current input to zero and sets the error status to false, providing a clean slate for further calculations.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 * @see Operator
 */
public class ClearError extends Operator {

    /**
     * Constructs a clear operator with the given state.
     * @param state The state of the calculator.
     */
    public ClearError(State state) {
        super(state);
    }

    /* Executes the clear operation by resetting the current input to zero and clearing any error status. */
    @Override
    public void execute() {
        state.setCurrentInput("0");
        state.setError(false);
    }
}