package Java.calculator.Operation;

import Java.calculator.util.State;
import Java.calculator.util.Stack;

/**
 * The Multiplication class represents the multiplication operator in a calculator.
 * It extends the BinaryOp class and implements the calculateResult method.
 *
 * @param <T> The type of elements stored in the stack.
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 * @see BinaryOp
 */
public class Multiplication<T> extends BinaryOp<T> {

    /**
     * Constructs a {@code Multiplication} object with the given state and stack.
     * @param state The state of the calculator.
     * @param stack The stack containing elements of type {@code T}.
     */
    public Multiplication(State state, Stack<T> stack) {
        super(state, stack);
    }

    /**
     * Calculates the result of the multiplication operation.
     * @param input1 The first operand.
     * @param input2 The second operand.
     * @return The result of the multiplication operation.
     */
    protected double calculateResult(double input1, double input2) {
        return input1 * input2;
    }
}


