package calculator.Operation;

public class Substraction extends Operator {
    private String symbol;
    public Substraction(){
        symbol = "-";
    }

    @Override
    public double execute(double op1, double op2) {
        return op1 - op2;
    }

    public double execute(double op1) {
        throw new UnsupportedOperationException("Subtraction operation requires two operands");
    }
}
