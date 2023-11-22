package calculator.Operation;

public class Squared extends Operator {
    private String symbol;
    public Squared(){
        symbol = "x^2";
    }

    public double execute(double op1) {
        return Math.pow(op1,2);
    }

    public double execute(double op1, double op2) {
        throw new UnsupportedOperationException("Squared operation does not support two operands");
    }
}
