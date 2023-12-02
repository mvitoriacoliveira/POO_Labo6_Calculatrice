package calculator;

import calculator.Operation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Calculator {
    private State state;
    private ArrayList<String> stateList;

    public Calculator() {
        this.state = new State("0");
        this.stateList = new ArrayList<>();
    }


    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            processInput(input);

            State currentState = new State(state.getCurrentInput());
            stateList.add(0,currentState.getCurrentInput());

            System.out.println(Arrays.toString(stateList.toArray()));

            String currentInput = state.getCurrentInput();

            double currentValue = Double.parseDouble(currentInput);

            state.getStack().push(currentValue);

            state.setCurrentInput("0");
        }

        System.out.println("Exiting Calculator.");
    }

    public static class OperatorList {
        public static Operator createOperator(String input, State state) {

            switch (input) {
                /*case "+":
                    return new Addition(state);
                case "-":
                    return new Subtraction(state);
                case "*":
                    return new Multiplication(state);
                case "/":
                    return new Divide(state);*/
                case "sqrt":
                    return new SquareRoot(state);
                case "x^2":
                    return new Squared(state);
                case "1/x":
                    return new Inverse(state);
                case "-/+":
                    return new UnaryOp(state);
                case "mr":
                    return new MemoryRecall(state);
                case "ms":
                    return new MemoryStore(state);
                case "<=":
                    return new Backspace(state);
                case "ce":
                    return new ClearError(state);
                /*case "c":
                    return new Clear(state);*/
                case "exit":
                    System.exit(0);
                default:
                    try {
                        // Si l'entrée est un nombre, créez un opérateur NumericKeypad
                        int number = Integer.parseInt(input);
                        return new NumericKeypad(number, state);
                    } catch (NumberFormatException e) {
                        // Si ce n'est ni un opérateur ni un nombre valide, retournez null
                        System.out.println("Opérateur inconnu : " + input);
                        return null;
                    }
            }
        }
    }

    private void processInput(String input) {
        Operator operator = OperatorList.createOperator(input, state);

        if (operator != null) {
            operator.execute();
        }

    }

    public static void main(String[] args) {
        System.out.println("java calculator");
        Calculator calculator = new Calculator();
        calculator.run();
    }
}
