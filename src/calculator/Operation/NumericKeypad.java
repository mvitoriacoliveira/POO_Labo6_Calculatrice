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

        String newInput = currentInput + operand;

        state.setCurrentInput(newInput);
    }

}
