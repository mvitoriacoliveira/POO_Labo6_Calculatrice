package calculator.Operation;

public class Divide<T extends Number> extends Operator<T>{

    private String symbol;
    public Divide(){
        symbol = "/";
    }

    @Override
    public T execute(T op1, T op2) {
        double op1d = convertDouble(op1);
        double op2d = convertDouble(op2);
        if (op2d != 0) {
            double result = op1d / op2d;
            return (T) Double.valueOf(result);
        }
        throw new ArithmeticException("Cannot divide by 0");
    }


    public T execute(T op1) {
        throw new UnsupportedOperationException("Divide operation requires two operands");
    }
}
