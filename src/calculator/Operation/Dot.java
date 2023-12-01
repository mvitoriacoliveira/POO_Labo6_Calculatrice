package calculator.Operation;
import calculator.State;

public class Dot extends Operator{


    public Dot (State state) {
        super(state);
    }
    @Override
    public void execute() {

        String currentInput = state.getCurrentInput();
        String newInput = currentInput + ".";

        state.setCurrentInput(newInput);
    }

    //TODO bloquer si on met 2 virgules dans la même state
}
