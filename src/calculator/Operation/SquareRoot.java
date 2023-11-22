package calculator.Operation;

public class SquareRoot extends Operator {
    private String symbol;
    public SquareRoot(){
        symbol = "Sqrt";
    }

    public double execute(double op1) {
        return Math.sqrt(op1);
    }
    public double execute(double op1, double op2) {
        throw new UnsupportedOperationException("SquareRoot operation does not support two operands");
    }
}
