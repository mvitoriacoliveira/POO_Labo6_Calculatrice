
package Java.calculator.Operation;

import Java.calculator.format.Formatter;
import Java.calculator.util.State;

/**
 * Represents a unary operation in a calculator.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 * @see Operator
 */
public class UnaryOp extends Operator {
    public UnaryOp(State s) {
        super(s);
    }


    @Override
    public void execute() {
        double input = Double.parseDouble(state.getCurrentInput());

        double result = -input;

        String formattedResult = Formatter.format(result);
        state.setCurrentInput(formattedResult);

    }
}