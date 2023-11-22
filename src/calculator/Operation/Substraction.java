package calculator.Operation;

public class Substraction <T extends Number> extends Operator<T>{
    private String symbol;
    public Substraction(){
        symbol = "-";
    }

    @Override
    public T execute(T op1, T op2) {
        double op1d = convertDouble(op1);
        double op2d = convertDouble(op2);
        double result = op1d - op2d;

        return (T) Double.valueOf(result);
    }

    public T execute(T op1) {
        throw new UnsupportedOperationException("Subtraction operation requires two operands");
    }
}
