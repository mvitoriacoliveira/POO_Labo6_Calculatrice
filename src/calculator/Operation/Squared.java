package calculator.Operation;

import calculator.State;
import calculator.Formatter;

public class Squared extends Operator {

    public Squared(State state) {
        super(state);
    }

    @Override
    public void execute() {

        String currentInput = state.getCurrentInput();

        try {
            double input = Double.parseDouble(currentInput);

            double result = Math.pow(input, 2);

            state.setCurrentInput(Formatter.format(result));
        } catch (NumberFormatException e) {
            state.setCurrentInput("Error");
        }
    }
}

