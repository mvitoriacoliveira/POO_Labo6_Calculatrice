package Java.calculator.Operation;

import Java.calculator.util.State;
import Java.calculator.util.Stack;

/**
 * Represents the addition operator in a calculator.
 *
 * @param <T> The type of elements stored in the stack.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 */
public class Addition<T> extends BinaryOp<T> {

    public Addition(State state, Stack<T> stack) {
        super(state, stack);
    }

    @Override
    protected double calculateResult(double input1, double input2) {
        return input1 + input2;
    }
}
