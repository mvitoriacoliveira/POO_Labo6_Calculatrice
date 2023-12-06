
package Java.calculator.Operation;

import Java.calculator.util.State;
import Java.calculator.util.Stack;

/**
 * Represents the enter operator in a calculator.
 * This class extends the Operator class and is designed to handle the enter input in a calculator.
 * When executed, it retrieves the current input as a double value, pushes it onto the calculator's stack,
 * and sets the current input to "0" for further input.
 *
 * @param <T> The type of elements stored in the stack.
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 * @see Operator
 */
public class Enter<T> extends Operator {

    /* The stack used for operation.*/
    private Stack<T> stack;

    /**
     * Constructs an enter operator with the given state and stack.
     * @param s The state of the calculator.
     * @param stack The stack of the calculator.
     */
    public Enter(State s, Stack<T> stack) {
        super(s);
        this.stack = stack;
    }

    /**
     * Executes the enter operation by retrieving the current input as a double value,
     * pushing it onto the calculator's stack, and setting the current input to "0".
     */
    @Override
    public void execute() {
        String currentInput = state.getCurrentInput();

        double currentValue = Double.parseDouble(currentInput);

        state.getStack().push(currentValue);

        state.setCurrentInput("0");
    }
}
