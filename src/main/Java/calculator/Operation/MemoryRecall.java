package Java.calculator.Operation;

import Java.calculator.util.State;

/**
 * The MemoryRecall class represents the memory recall operator in a calculator.
 * The value stored in memory will be retrieved and displayed in the current input.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 * @see Operator
 */
public class MemoryRecall extends Operator{

    /**
     * Constructs a MemoryRecall object with the given state.
     *
     * @param s The state of the calculator.
     */
    public MemoryRecall(State s) {
        super(s);
    }

    /**
     * Executes the memory recall operation.
     * Retrieves the value stored in memory and sets it as the current input.
     */
    @Override
    public void execute() {
        String memoryValue = state.getMemory();

        state.setCurrentInput(memoryValue);
    }
}

