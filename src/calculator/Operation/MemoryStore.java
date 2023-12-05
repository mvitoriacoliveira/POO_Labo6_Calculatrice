package calculator.Operation;

import calculator.State;

/**
 * Represents the memory recall operator in a calculator.
 * The value will be stored in memory for later retrieval.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 */
public class MemoryStore extends Operator{

    public MemoryStore(State s) {
        super(s);
    }

    @Override
    public void execute() {
        String currentInput = state.getCurrentInput();

        state.setMemory(currentInput);
    }
}

