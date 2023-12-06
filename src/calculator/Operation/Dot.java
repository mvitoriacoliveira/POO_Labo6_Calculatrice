package calculator.Operation;
import calculator.util.State;

/**
 * Represents the dot operator in a calculator.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 */
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
