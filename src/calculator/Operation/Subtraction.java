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
public class Subtraction<T> extends BinaryOp<T> {

    public Subtraction(State state, Stack<T> stack) {
        super(state, stack);
    }

    @Override
    protected double calculateResult(double input1, double input2) {
        return input2 - input1;
    }
}