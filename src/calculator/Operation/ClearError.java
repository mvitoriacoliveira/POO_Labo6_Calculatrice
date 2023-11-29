package calculator.Operation;

public class ClearError <T extends Number> extends Operator<T>{
    private double operand1;

    public ClearError(double op1) {
        operand1 = op1;
    }

    @Override
    public T execute() {
        operand1 = (T) (Double) 0.0;
        return operand1;
    }
}
