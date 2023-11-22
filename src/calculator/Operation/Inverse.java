package calculator.Operation;

public class Inverse<T extends Number> extends Operator<T>  {
    private String symbol;
    public Inverse(){
        symbol = "1/x";
    }


    @Override
    public T execute(T op1) {
        double op1d = convertDouble(op1);
        double result = 1/ op1d;

        return (T) Double.valueOf(result);
    }

    public T execute(T op1, T op2) {
        throw new UnsupportedOperationException("Inverse operation does not support two operands");
    }
}
