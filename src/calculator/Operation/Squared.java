package calculator.Operation;

import calculator.State;
import calculator.Formatter;

public class Squared extends Operator{

    public Squared(State s){
        super(s);
    }
    @Override
    public void execute() {
        double input = Double.parseDouble(state.getCurrentInput());
        double result = Math.pow(input, 2);
        String formattedResult = Formatter.format(result);
        state.setCurrentInput(formattedResult);
    }
}

