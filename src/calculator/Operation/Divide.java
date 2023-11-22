package calculator.Operation;

public class Divide extends Operator {

    private String symbol;
    public Divide(){
        symbol = "/";
    }

    @Override
    public double execute(double op1, double op2) {
        if (op2 != 0) {
            return op1 / op2;
        }
        throw new ArithmeticException("Cannot divide by 0");
    }

    public double execute(double op1) {
        throw new UnsupportedOperationException("Divide operation requires two operands");
    }
}
