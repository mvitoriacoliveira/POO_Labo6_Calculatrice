package calculator.Operation;

public class Addition<T extends Number> extends Operator<T> {

    private final T operand1;
    private final T operand2;

    public Addition(T op1, T op2){
        operand1 = op1;
        operand2 = op2;
    }
    @Override
    public T execute() {
        return (T) Double.valueOf(operand1.doubleValue() + operand2.doubleValue());
    }

}