package calculator.Operation;

import calculator.util.State;

/**
 * Represents the clear operator in a calculator.
 * This class will clear the current state and any possible errors to reset everything to zero.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 */
public class ClearError extends Operator {

    public ClearError(State state) {
        super(state);
    }

    @Override
    public void execute() {
        state.setCurrentInput("0");
        state.setError(false);
    }
}