package Java.calculator.Operation;

import Java.calculator.util.State;

import static Java.calculator.format.Formatter.isNumeric;

/**
 * The NumericKeypad class represents a numeric keypad operation in a calculator.
 * It extends the Operator class and implements the execute method.
 *
 * <p>The class is responsible for handling numeric input from the calculator's keypad, validating
 * the input, and updating the calculator's state accordingly.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 * @see Operator
 */
public class NumericKeypad extends Operator {
    /* The numeric operand received from the calculator's keypad. */
    private final String operand;

    /**
     * Constructs a NumericKeypad object with the given operand and state.
     * @param operand The numeric operand received from the calculator's keypad.
     * @param state   The state of the calculator.
     */
    public NumericKeypad(String operand, State state) {
        super(state);
        this.operand = operand;
    }

    /**
     * Executes the numeric keypad operation.
     * Validates the input and updates the calculator's state with the new input.
     * If the input is not valid, sets an error flag and prints an error message to the console.
     */
    @Override
    public void execute() {
        if (!ErrorState()) {
            String currentInput = state.getCurrentInput();

            if (isNumeric(currentInput + operand)) {
                String newInput = currentInput.equals("0") ? operand : currentInput + operand;
                state.setCurrentInput(newInput);
            } else {
                state.setError(true);
                System.err.println("Invalid input: " + operand);
            }
        } else {
            state.setError(true);
        }
    }

}
