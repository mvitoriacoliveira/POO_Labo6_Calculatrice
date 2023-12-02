package calculator.Operation;

import calculator.State;

public class ClearError extends Operator {

    public ClearError(State state) {
        super(state);
    }

    @Override
    public void execute() {
        state.setCurrentInput("0");
    }

    //TODO effacer erreurs
}