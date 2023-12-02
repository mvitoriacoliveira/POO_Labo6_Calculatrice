package calculator.Operation;

import calculator.Formatter;
import calculator.State;
import calculator.Stack;

public class Subtraction<T> extends Operator {

    private final Stack<T> stack;

    public Subtraction(State state, Stack<T> stack) {
        super(state);
        this.stack = stack;
    }

    @Override
    public void execute() {
        // Récupérer le premier élément de la pile
        if (!stack.isEmpty()) {
            T stackTop = stack.pop();

            // Récupérer la valeur actuelle de l'état
            String currentInput = state.getCurrentInput();

            try {
                // Convertir les deux valeurs en double
                double input1 = Double.parseDouble(currentInput);
                double input2 = Double.parseDouble(stackTop.toString());

                // Calculer la soustraction
                double result = input2 - input1;

                // Mettre à jour l'état avec le résultat formaté
                state.setCurrentInput(Formatter.format(result));
            } catch (NumberFormatException e) {
                // Gérer l'exception si la conversion en double échoue
                state.setCurrentInput("Error");
            }
        }
    }
}