package calculator;

import calculator.Operation.*;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

import static calculator.Formatter.formatOneDecimal;

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
            stateList.add(0, currentState.getCurrentInput());

            System.out.println(Arrays.toString(stateList.toArray()));

            String currentInput = state.getCurrentInput();

            double currentValue = Double.parseDouble(currentInput);

            state.getStack().push(currentValue);

            state.setCurrentInput("0");
        }

        System.out.println("Exiting Calculator.");
    }

    public static class OperatorList {
        public static Operator createOperator(String input, State state, ArrayList<String> stateList) {

            State state0;
            Stack<String> stackState = new Stack<>();

            for (String element : stateList) {
                stackState.push(element);
            }

            if (!stateList.isEmpty()) {
                state0 = new State(stateList.get(0));
                System.out.println("tableau premier élément : " + stateList.get(0));
            } else {
                state0 = new State("0");
            }

            System.out.println("state 0 : " + state0);

            switch (input) {
                case "+":
                    return new Addition(state0, stackState);
                case "-":
                    return new Subtraction(state0, stackState);
                case "*":
                    return new Multiplication(state0, stackState);
                case "/":
                    return new Divide(state0, stackState);
                case "sqrt":
                    return new SquareRoot(state0);
                case "x^2":
                    return new Squared(state0);
                case "1/x":
                    return new Inverse(state0);
                case "-/+":
                    return new UnaryOp(state0);
                case "mr":
                    return new MemoryRecall(state0);
                case "ms":
                    return new MemoryStore(state0);
                case "<=":
                    return new Backspace(state0);
                case "ce":
                    return new ClearError(state0);
                case "c":
                    return new Clear(state0, stackState);
                case "exit":
                    System.exit(0);
                default:
                    try {
                        //String stringValue = formatString(input);
                        return new NumericKeypad(input, state);
                    } catch (NumberFormatException e) {
                        System.out.println("Error unknown operator : " + input);
                        return null;
                    } /*catch (ParseException e) {
                        throw new RuntimeException(e);
                    }*/
            }
        }
    }

    private void processInput(String input) {
        Operator operator = OperatorList.createOperator(input, state, stateList);

        if (operator != null) {
            if (operator instanceof Addition || operator instanceof Subtraction || operator instanceof Multiplication || operator instanceof Divide) {
                if (state.getStack().getSize() >= 2) {
                    operator.execute();
                    stateList.remove(0);
                    stateList.remove(0);
                    updateCurrentState(formatOneDecimal(operator.state.getCurrentInput()));
                } else {
                    System.out.println("Not enough elements in the stack.");
                }
            } else if (operator instanceof Squared || operator instanceof SquareRoot || operator instanceof UnaryOp || operator instanceof Inverse) {
                if (state.getStack().getSize() >= 1) {
                    operator.execute();
                    stateList.remove(0);
                    updateCurrentState(operator.state.getCurrentInput());
                } else {
                    System.out.println("Not enough elements in the stack.");
                }
            } else {
                operator.execute();
                updateCurrentState(formatOneDecimal(operator.state.getCurrentInput()));
            }

        }
    }

    private void updateCurrentState(String input) {
        state.setCurrentInput(input);
    }

   /* private String formatWithOneDecimalPlace(String input) {
        try {
            input = input.replace(',', '.');
            double value = Double.parseDouble(input);

            // Formater avec un chiffre après la virgule
            DecimalFormat decimalFormat = new DecimalFormat("#.0", DecimalFormatSymbols.getInstance(Locale.US));

            return decimalFormat.format(value);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return input; // En cas d'erreur, retourner la chaîne d'origine
        }
    }*/

    public static void main(String[] args) {
        System.out.println("java calculator");
        Calculator calculator = new Calculator();
        calculator.run();
    }
}

//TODO mr et ms problème
//TODO problème dans ordre des opération
/* EX :
tableau premier élément : 6.0
        state 0 : current state : 6.0 current stack : []
        [5.0, 6.0, 0]
        > -
        tableau premier élément : 5.0
        state 0 : current state : 5.0 current stack : []
        [-5, 0]*/
