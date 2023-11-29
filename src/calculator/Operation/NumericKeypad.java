package calculator.Operation;

public class NumericKeypad<T extends Number> extends Operator<T> {
    private final int operand1;
    public int getOperand() {
        return operand1;
    }

    public NumericKeypad(int op1) {
        operand1 = op1;
    }

    @Override
    public T execute() {
        int value = operand1;
        int result = Math.abs(value) % 10;
        return (T) Integer.valueOf(result);

    }
}
