package calculator.Operation;

import calculator.Formatter;
import calculator.State;
import calculator.Stack;

public class Divide<T> extends Operator {

    private final Stack<T> stack;

    public Divide(State state, Stack<T> stack) {
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

                if (input1 != 0) {
                    double result = input2 / input1;
                    state.setCurrentInput(Formatter.format(result));
                } else {
                    state.setCurrentInput("Infinity");
                }
            } catch (NumberFormatException e) {
                state.setCurrentInput("Error");
            }
        }
    }
}
