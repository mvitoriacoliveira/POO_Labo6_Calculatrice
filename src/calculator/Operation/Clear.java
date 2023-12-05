package calculator.Operation;

import calculator.State;
import calculator.Stack;

/**
 * Represents the clear operator in a calculator.
 * This class will clear the current state, stack, and any possible errors to reset everything to zero.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 */
public class Clear<T> extends ClearError {

    private final Stack<T> stack;

    public Clear(State state, Stack<T> stack) {
        super(state);
        this.stack = stack;
    }

    @Override
    public void execute() {
        super.execute();

        int stackSize = stack.getSize();
        for (int i = 0; i < stackSize; i++) {
            stack.pop();
        }
    }
}