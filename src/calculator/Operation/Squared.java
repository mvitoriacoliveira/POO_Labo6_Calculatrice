package calculator.Operation;

public class Squared<T extends Number> extends Operator<T> {
    private final T operand1;

    public Squared(T op1){
        operand1 = op1;
    }
    @Override
    public T execute() {
        return (T) Double.valueOf(Math.pow(operand1.doubleValue(),2));
    }
}
