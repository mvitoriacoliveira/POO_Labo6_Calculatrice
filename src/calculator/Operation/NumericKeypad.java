package calculator.Operation;

public class NumericKeypad<T extends Number> extends Operator<T> {
    private final int operand1;

    public NumericKeypad(int op1) {
        operand1 = op1;
    }

    @Override
    public T execute() {
        int value = operand1;
        // Utilisation de la logique de modulo pour obtenir un nombre entre 0 et 9
        int result = Math.abs(value) % 10;
        return (T) Integer.valueOf(result);

    }
}
