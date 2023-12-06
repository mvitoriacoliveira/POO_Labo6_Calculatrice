package Java.calculator.Operation;

import Java.calculator.format.Formatter;
import Java.calculator.util.State;
import Java.calculator.util.Stack;

/**
 * Represents the divide operator in a calculator.
 * This class extends the BinaryOp class and is designed to perform division operations on the calculator's stack.
 * The division operation is executed by popping two operands from the stack and dividing the second operand by the first.
 * The result is then formatted using the Formatter class and updated in the calculator's state.
 * In case of division by zero, the result is set to "Infinity," and an error flag is raised.
 *
 * @param <T> The type of elements stored in the stack.
 * @see BinaryOp
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 */
public class Divide<T> extends BinaryOp<T> {

    /**
     * Constructs a divide operator with the given state and stack.
     * @param state The state of the calculator.
     * @param stack The stack of the calculator.
     */
    public Divide(State state, Stack<T> stack) {
        super(state, stack);
    }

    /**
     * Executes the divide operation by popping two operands from the stack and dividing the second operand by the first.
     * The result is formatted and updated in the calculator's state.
     * If the division by zero occurs, the result is set to "Infinity," and an error flag is raised.
     */
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

    /**
     * Calculates the result of the division operation.
     * Throws an ArithmeticException in case of division by zero.
     * @param input1 The first operand.
     * @param input2 The second operand.
     * @return The result of the division.
     * @throws ArithmeticException If attempting to divide by zero.
     */
    protected double calculateResult(double input1, double input2) {
        if (input1 == 0) {
            throw new ArithmeticException();
        }
        return input2 / input1;
    }
}
