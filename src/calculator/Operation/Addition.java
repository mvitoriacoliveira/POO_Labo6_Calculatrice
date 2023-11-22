package calculator.Operation;

public class Addition extends Operator {
    private String symbol;
    public Addition(){
        symbol = "+";
    }

    @Override
    public double execute(double op1, double op2) {
        return op1 + op2;
    }

    public double execute(double op1) {
        throw new UnsupportedOperationException("Addition operation requires two operands");
    }
}
