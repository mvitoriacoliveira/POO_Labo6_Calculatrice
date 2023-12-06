
package calculator.Operation;

import calculator.util.State;

/**
 * Represents the backspace operator in a calculator.
 *  This operator removes the last character from the current input in the calculator's state.
 *  If the current input is not empty, it removes the last character; otherwise, it has no effect.
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 * @see Operator
 */
public class Backspace extends Operator{

    /**
     * Constructs a Backspace operator with the given state.
     * @param s The state of the calculator.
     */
    public Backspace(State s) {
        super(s);
    }

    /**
     * Executes the backspace operation.
     * Removes the last character from the current input in the calculator's state.
     * If the current input is not empty, it removes the last character; otherwise, it has no effect.
     */
    @Override
    public void execute() {
        String currentInput = state.getCurrentInput();

        if (!currentInput.isEmpty()) {
            currentInput = currentInput.substring(0, currentInput.length() - 1);
            state.setCurrentInput(currentInput);
        }
    }
}