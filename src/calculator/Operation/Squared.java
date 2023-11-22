package calculator.Operation;

public class Squared<T extends Number> extends Operator<T> {
    private String symbol;
    public Squared(){
        symbol = "x^2";
    }

    public T execute(T op1) {
        double op1d = convertDouble(op1);
        double result = Math.pow(op1d,2);

        return (T) Double.valueOf(result);
    }

    public T execute(T op1, T op2) {
        throw new UnsupportedOperationException("Squared operation does not support two operands");
    }
}
