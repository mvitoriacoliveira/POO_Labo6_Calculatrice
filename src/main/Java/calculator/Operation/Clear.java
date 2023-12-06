package Java.calculator.Operation;

import Java.calculator.util.State;
import Java.calculator.util.Stack;

/**
 * Represents the clear operator in a calculator.
 * This class extends the ClearError class and is designed to clear the current state, stack, and errors.
 * It resets everything to zero, providing a clean slate for further calculations.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 * @see ClearError
 */
public class Clear<T> extends ClearError {

    /* The stack associated with the calculator.*/
    private final Stack<T> stack;

    /**
     * Constructs a clear operator with the given state and stack.
     * @param state The state of the calculator.
     * @param stack The stack associated with the calculator.
     */
    public Clear(State state, Stack<T> stack) {
        super(state);
        this.stack = stack;
    }

    /**
     * Executes the clear operation by invoking the clear method of the superclass (ClearError)
     * and then clearing the stack by popping all elements.
     */
    @Override
    public void execute() {
        super.execute();

        int stackSize = stack.getSize();
        for (int i = 0; i < stackSize; i++) {
            stack.pop();
        }
    }
}