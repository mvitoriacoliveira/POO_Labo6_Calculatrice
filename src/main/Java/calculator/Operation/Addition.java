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
 * @see Java.calculator.Operation.BinaryOp
 */
public class Addition<T> extends BinaryOp<T> {

    /**
     * Constructs an Addition operator with the given state and stack.
     *
     * @param state The state of the calculator.
     * @param stack The stack used in the calculator.
     */
    public Addition(State state, Stack<T> stack) {
        super(state, stack);
    }

    /**
     * Calculates the result of the addition operation.
     * @param input1 The first operand.
     * @param input2 The second operand.
     * @return The result of the addition operation.
     */
    @Override
    protected double calculateResult(double input1, double input2) {
        return input1 + input2;
    }
}
