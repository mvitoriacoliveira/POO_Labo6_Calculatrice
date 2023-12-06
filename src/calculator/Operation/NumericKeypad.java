package calculator.Operation;

import calculator.util.State;

import static calculator.format.Formatter.isNumeric;

/**
 * Represents a numeric keypad operation in a calculator.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 */
public class NumericKeypad extends Operator {
    private final String operand;

    public NumericKeypad(String operand, State state) {
        super(state);
        this.operand = operand;
    }

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
