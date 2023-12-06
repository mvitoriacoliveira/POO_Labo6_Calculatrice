package Java.calculator.Operation;

import Java.calculator.util.State;

/**
 * Represents the memory recall operator in a calculator.
 * The value stored in memory will be retrieved and displayed.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 */
public class MemoryRecall extends Operator{

    public MemoryRecall(State s) {
        super(s);
    }

    @Override
    public void execute() {
        String memoryValue = state.getMemory();

        state.setCurrentInput(memoryValue);
    }
}

