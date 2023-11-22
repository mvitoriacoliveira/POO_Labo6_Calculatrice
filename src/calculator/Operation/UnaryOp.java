package calculator.Operation;

public class UnaryOp extends Operator {
    private String symbol;
    public UnaryOp(){
        symbol = "+/-";
    }

    public double execute(double op1) {
        return (-op1);
    }

    public double execute(double op1, double op2) {
        throw new UnsupportedOperationException("UnaryOperator operation does not support two operands");
    }
}
