/*
package calculator.Operation;

public class Divide<T extends Number> extends Operator<T>{

    private final T operand1;
    private final T operand2;

    public Divide(T op1, T op2){
        operand1 = op1;
        operand2 = op2;
    }
    @Override
    public T execute() {
        if (operand2.doubleValue() != 0) {
            return (T) Double.valueOf(operand1.doubleValue() / operand2.doubleValue());
        } else {
            throw new ArithmeticException("Cannot divide by 0");
        }
    }

}
*/
