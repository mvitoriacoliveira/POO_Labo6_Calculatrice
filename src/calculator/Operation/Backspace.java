
package calculator.Operation;

import calculator.State;

public class Backspace extends Operator{
    public Backspace(State s) {
        super(s);
    }

    @Override
    public void execute() {
        String currentInput = state.getCurrentInput();

        if (currentInput.length() > 0) {
            currentInput = currentInput.substring(0, currentInput.length() - 1);
            state.setCurrentInput(currentInput);
        }
    }
}

