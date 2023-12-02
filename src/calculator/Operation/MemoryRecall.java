package calculator.Operation;

import calculator.State;

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

