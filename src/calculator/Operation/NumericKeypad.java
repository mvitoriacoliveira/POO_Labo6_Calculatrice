package calculator.Operation;

import calculator.State;

public class NumericKeypad extends Operator {
    private final int operand;

    public NumericKeypad(int operand, State state) {
        super(state);
        this.operand = operand;
    }

    @Override
    public void execute() {
        String currentInput = state.getCurrentInput();

        String newInput = currentInput.equals("0") ? String.valueOf(operand) : currentInput + operand;

        state.setCurrentInput(newInput);
    }

}
