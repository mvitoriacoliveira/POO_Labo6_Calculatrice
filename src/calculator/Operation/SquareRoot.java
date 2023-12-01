package calculator.Operation;
import calculator.State;


public class SquareRoot extends Operator {

    public SquareRoot(State s){
        super(s);
    }
    public void execute() {
        double input = Double.parseDouble(state.getCurrentInput());
        if (input >= 0) {
            state.setCurrentInput(String.valueOf(Math.sqrt(input)));
        } else {
            throw new ArithmeticException("Cannot take the square root of a negative number.");
        }
    }


}

