package Java.calculator.Operation;

import Java.calculator.format.Formatter;
import Java.calculator.util.State;
import Java.calculator.util.Stack;

/**
 * Represents the divide operator in a calculator.
 *
 * @param <T> The type of elements stored in the stack.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 */
public class Divide<T> extends BinaryOp<T> {

    public Divide(State state, Stack<T> stack) {
        super(state, stack);
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
                    state.setError(true);
                }
            } catch (NumberFormatException e) {
                state.setCurrentInput("Error");
                state.setError(true);
            }
        }
    }

    protected double calculateResult(double input1, double input2) {
        if (input1 == 0) {
            throw new ArithmeticException();
        }
        return input2 / input1;
    }
}
