
package calculator.Operation;

import calculator.State;
import calculator.Stack;

public class Enter<T> extends Operator {
    private Stack<T> stack;

    public Enter(State s, Stack<T> stack) {
        super(s);
        this.stack = stack;
    }

    @Override
    public void execute() {
        stack.push((T) state.getCurrentInput());
    }
}
