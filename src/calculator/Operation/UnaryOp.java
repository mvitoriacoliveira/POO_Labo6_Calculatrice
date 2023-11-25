package calculator.Operation;

public class UnaryOp<T extends Number> extends Operator<T> {
    private final T operand1;

    public UnaryOp(T op1){
        operand1 = op1;
    }
    @Override
    public T execute() {
        return (T) Double.valueOf(-operand1.doubleValue());
    }
}
