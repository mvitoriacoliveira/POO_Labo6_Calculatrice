
package calculator.Operation;

import calculator.Formatter;
import calculator.State;

public class UnaryOp extends Operator {
    public UnaryOp(State s) {
        super(s);
    }


    @Override
    public void execute() {
        double input = Double.parseDouble(state.getCurrentInput());

        double result = -input;
        String formattedResult = Formatter.format(result);
        state.setCurrentInput(formattedResult);

    }
}
