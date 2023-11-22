package calculator.Operation;

public class SquareRoot<T extends Number> extends Operator<T> {
    private String symbol;
    public SquareRoot(){
        symbol = "Sqrt";
    }

    public T execute(T op1) {
        double op1d = convertDouble(op1);
        double result = Math.sqrt(op1d);

        return (T) Double.valueOf(result);
    }
    public T execute(T op1, T op2)  {
        throw new UnsupportedOperationException("SquareRoot operation does not support two operands");
    }
}
