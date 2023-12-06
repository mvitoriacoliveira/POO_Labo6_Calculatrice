package calculator.Operation;

import calculator.util.State;
import calculator.format.Formatter;

/**
 * Represents a squared operation in a calculator.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 */
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
            state.setError(true);
        }
    }
}

