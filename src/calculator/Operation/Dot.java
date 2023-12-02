package calculator.Operation;
import calculator.State;

public class Dot extends Operator{


    public Dot (State state) {
        super(state);
    }
    @Override
    public void execute() {

        String currentInput = state.getCurrentInput();

        if (!currentInput.contains(".")) {
            String newInput = currentInput + ".";
            state.setCurrentInput(newInput);
        }
    }

}
