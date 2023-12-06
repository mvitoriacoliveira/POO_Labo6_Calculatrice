package Java.calculator.Operation;

import Java.calculator.util.State;

/**
 * The MemoryStore class represents the memory store operator in a calculator.
 * The current input value will be stored in memory for later retrieval.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 * @see Operator
 */
public class MemoryStore extends Operator{

    /**
     * Constructs a MemoryStore object with the given state.
     *
     * @param s The state of the calculator.
     */
    public MemoryStore(State s) {
        super(s);
    }

    /**
     * Executes the memory store operation.
     * Stores the current input value in the calculator's memory.
     */
    @Override
    public void execute() {
        String currentInput = state.getCurrentInput();

        state.setMemory(currentInput);
    }
}

