package calculator.Operation;

import calculator.Formatter;
import calculator.State;
import calculator.Stack;

public class Addition<T> extends Operator {

    private final Stack<T> stack;

    public Addition(State state, Stack<T> stack) {
        super(state);
        this.stack = stack;
    }

    @Override
    public void execute() {

        if (!stack.isEmpty()) {
            T stackTop = stack.pop();
            String currentInput = state.getCurrentInput();

            try {
                double input1 = Double.parseDouble(currentInput);
                double input2 = Double.parseDouble(stackTop.toString());

                double result = input1 + input2;

                state.setCurrentInput(Formatter.format(result));
            } catch (NumberFormatException e) {
                state.setCurrentInput("Error");
            }
        }
    }
}
