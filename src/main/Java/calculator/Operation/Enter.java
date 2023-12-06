
package Java.calculator.Operation;

import Java.calculator.util.State;
import Java.calculator.util.Stack;

/**
 * Represents the enter operator in a calculator.
 * The current state will be placed on top of the stack.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 */
public class Enter<T> extends Operator {
    private Stack<T> stack;

    public Enter(State s, Stack<T> stack) {
        super(s);
        this.stack = stack;
    }

    @Override
    public void execute() {
        String currentInput = state.getCurrentInput();

        double currentValue = Double.parseDouble(currentInput);

        state.getStack().push(currentValue);

        state.setCurrentInput("0");
    }
}
