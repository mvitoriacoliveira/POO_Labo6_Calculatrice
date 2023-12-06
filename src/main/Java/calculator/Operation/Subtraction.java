package Java.calculator.Operation;

import Java.calculator.util.State;
import Java.calculator.util.Stack;

/**
 * Represents the subtraction operator in a calculator.
 *
 * @param <T> The type of elements stored in the stack.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 * @see BinaryOp
 */
public class Subtraction<T> extends BinaryOp<T> {

    /**
     * Constructs a Subtraction object with the given state and stack.
     * @param state The state of the calculator.
     * @param stack The stack used for storing elements.
     */
    public Subtraction(State state, Stack<T> stack) {
        super(state, stack);
    }

    /**
     * Calculates the result of the subtraction operation.
     * Overrides the calculateResult method in the BinaryOp class.
     * @param input1 The first operand.
     * @param input2 The second operand.
     * @return The result of the subtraction operation.
     */
    @Override
    protected double calculateResult(double input1, double input2) {
        return input2 - input1;
    }
}