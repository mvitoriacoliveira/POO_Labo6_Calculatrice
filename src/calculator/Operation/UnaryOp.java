package calculator.Operation;

public class UnaryOp<T extends Number> extends Operator<T> {
    private String symbol;
    public UnaryOp(){
        symbol = "+/-";
    }

    public T execute(T op1) {
        double op1d = convertDouble(op1);
        double result = (-op1d);

        return (T) Double.valueOf(result);
    }

    public T execute(T op1, T op2) {
        throw new UnsupportedOperationException("UnaryOperator operation does not support two operands");
    }
}
