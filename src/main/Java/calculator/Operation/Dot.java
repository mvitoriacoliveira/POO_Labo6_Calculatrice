package Java.calculator.Operation;
import Java.calculator.util.State;

/**
 * Represents the dot operator in a calculator.
 * This class extends the Operator class and is designed to handle the dot (decimal point) input in a calculator.
 * When executed, it checks if the current input already contains a dot, and if not, it appends a dot to the current input.
 * The updated input is then set in the calculator's state.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 * @see Operator
 */
public class Dot extends Operator{

    /**
     * Constructs a dot operator with the given state.
     * @param state The state of the calculator.
     */
    public Dot (State state) {
        super(state);
    }

    /**
     * Executes the dot operation by checking if the current input already contains a dot.
     * If not, it appends a dot to the current input, and the updated input is set in the calculator's state.
     */
    @Override
    public void execute() {

        String currentInput = state.getCurrentInput();

        if (!currentInput.contains(".")) {
            String newInput = currentInput + ".";
            state.setCurrentInput(newInput);
        }
    }

}
