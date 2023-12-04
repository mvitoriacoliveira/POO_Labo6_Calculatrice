package calculator.Operation;

import calculator.State;

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
            String newInput = currentInput.equals("0") ? operand : currentInput + operand;
            state.setCurrentInput(newInput);
        } else {
            state.setError(true);
        }
    }

}
