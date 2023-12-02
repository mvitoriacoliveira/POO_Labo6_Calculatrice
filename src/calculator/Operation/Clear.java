package calculator.Operation;

import calculator.State;
import calculator.Stack;


public class Clear<T> extends Operator {

    private final Stack<T> stack;

    public Clear(State state, Stack<T> stack) {
        super(state);
        this.stack = stack;
    }

    @Override
    public void execute() {
        state.setCurrentInput("0");

        //stack.clear();
        int stackSize = stack.getSize();
        for (int i = 0; i < stackSize; i++) {
            stack.pop();
        }

        state.setError(false);
        state.setErrorMessage(null);
    }
}