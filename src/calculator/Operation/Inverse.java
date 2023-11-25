package calculator.Operation;

public class Inverse<T extends Number> extends Operator<T>  {
    private final T operand1;

    public Inverse(T op1){
        operand1 = op1;
    }
    @Override
    public T execute() {
        if (operand1.doubleValue() != 0) {
            return (T) Double.valueOf(1 / operand1.doubleValue());
        } else {
            throw new ArithmeticException("Cannot divide by 0");
        }
    }
}
