package Java.calculator.Operation;

import Java.calculator.format.Formatter;
import Java.calculator.util.State;
import Java.calculator.util.Stack;

/**
 * An abstract class representing a binary operator in a calculator.
 * This class extends the Operator class and provides a common structure for binary operations.
 * It includes methods to execute the binary operation, perform the actual calculation, and handle errors.
 * Subclasses must implement the calculateResult method to define the specific binary operation.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 * @see Operator
 */
public abstract class BinaryOp<T> extends Operator{

    /* The stack used for binary operations.*/
    protected final Stack<T> stack;

    /**
     * Constructs a binary operator with the given state and stack.
     * @param s     The state of the calculator.
     * @param stack The stack used for binary operations.
     */
    public BinaryOp(State s, Stack<T> stack) {
        super(s);
        this.stack = stack;
    }


    /**
     * Executes the binary operation.
     * Retrieves the top element from the stack, parses the current input, and performs the binary operation.
     * Handles errors such as number format and arithmetic exceptions.
     */
    @Override
    public void execute() {
        if (!stack.isEmpty()) {
            T stackTop = stack.pop();
            String currentInput = state.getCurrentInput();

            try {
                double input1 = Double.parseDouble(currentInput);
                double input2 = Double.parseDouble(stackTop.toString());

                performBinaryOperation(input1, input2);
            } catch (NumberFormatException e) {
                state.setCurrentInput("Error");
                state.setError(true);
            } catch (ArithmeticException e){
                state.setCurrentInput("Infinity");
                state.setError(true);
            }
        }
    }

    /**
     * Performs the specific binary operation using the given inputs.
     * Subclasses must implement this method to define the operation.
     * @param input1 The first operand.
     * @param input2 The second operand.
     */
    protected void performBinaryOperation(double input1, double input2) {
        double result = calculateResult(input1, input2);
        state.setCurrentInput(Formatter.formatOneDecimal(String.valueOf(result)));
    }

    /**
     * Calculates the result of the binary operation using the given inputs.
     * Subclasses must implement this method to provide the specific calculation.
     * @param input1 The first operand.
     * @param input2 The second operand.
     * @return The result of the binary operation.
     */
    protected abstract double calculateResult(double input1, double input2);
}
