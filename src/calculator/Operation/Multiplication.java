package calculator.Operation;

import calculator.Formatter;
import calculator.State;
import calculator.Stack;

/**
 * Represents the multiplication operator in a calculator.
 *
 * @param <T> The type of elements stored in the stack.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 */
public class Multiplication<T> extends BinaryOp<T> {

    public Multiplication(State state, Stack<T> stack) {
        super(state, stack);
    }

    protected double calculateResult(double input1, double input2) {
        return input1 * input2;
    }
}


