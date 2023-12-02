package calculator.Operation;

import calculator.State;

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

