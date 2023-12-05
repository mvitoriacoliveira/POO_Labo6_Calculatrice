package calculator.Operation;

import calculator.Formatter;
import calculator.State;
import calculator.Stack;

/**
 * Represents the subtraction operator in a calculator.
 *
 * @param <T> The type of elements stored in the stack.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 */
public class Subtraction<T> extends Operator {

    private final Stack<T> stack;

    public Subtraction(State state, Stack<T> stack) {
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

                double result = input2 - input1;

                state.setCurrentInput(Formatter.format(result));
            } catch (NumberFormatException e) {
                state.setCurrentInput("Error");
                state.setError(true);
            }
        }
    }
}