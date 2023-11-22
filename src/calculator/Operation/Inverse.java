package calculator.Operation;

public class Inverse extends Operator {
    private String symbol;
    public Inverse(){
        symbol = "1/x";
    }


    public double execute(double op1) {
        return 1 / op1;
    }
    public double execute(double op1, double op2) {
        throw new UnsupportedOperationException("Inverse operation does not support two operands");
    }
}
