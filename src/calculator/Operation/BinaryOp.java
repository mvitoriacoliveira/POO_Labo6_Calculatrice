package calculator.Operation;

import calculator.Formatter;
import calculator.State;
import calculator.Stack;

public abstract class BinaryOp<T> extends Operator{

    protected final Stack<T> stack;

    public BinaryOp(State s, Stack<T> stack) {
        super(s);
        this.stack = stack;
    }

    @Override
    public void execute() {
        if (!stack.isEmpty()) {
            T stackTop = stack.pop();
            String currentInput = state.getCurrentInput();

            try {
                double input1 = Double.parseDouble(currentInput);
                double input2 = Double.parseDouble(stackTop.toString());

                performBinaryOperation(input1, input2);
            } catch (NumberFormatException e) {
                state.setCurrentInput("Error");
                state.setError(true);
            } catch (ArithmeticException e){
                state.setCurrentInput("Infinity");
                state.setError(true);
                state.setErrorMessage("Infinity");
            }
        }
    }

    protected void performBinaryOperation(double input1, double input2) {
        double result = calculateResult(input1, input2);
        state.setCurrentInput(Formatter.format(result));
    }

    protected abstract double calculateResult(double input1, double input2);

}
