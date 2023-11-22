package calculator.Operation;

public class Multiplication extends Operator {
    private String symbol;
    public Multiplication(){
        symbol = "*";
    }

    @Override
    public double execute(double op1, double op2) {
        return op1 * op2;
    }

    public double execute(double op1) {
        throw new UnsupportedOperationException("Multiplication operation requires two operands");
    }
}
