package calculator;

import calculator.Operation.*;

import java.util.Scanner;

public class Calculator2 {
    private State state;
    private Stack stack;

    public Calculator2() {
        this.state = new State("0");
        this.stack = state.getStack();
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

            System.out.println("State : " + state);
            System.out.println("Current input : " + state.getCurrentInput());
        }
        System.out.println("exiting calculator");
    }

    public static class OperatorList {
        public static Operator createOperator(String input, State state, Stack stack) {

            //State currentInput = ;

            switch (input) {
                case "+":
                    return new Addition(state, stack);
                case "-":
                    return new Subtraction(state, stack);
                case "*":
                    return new Multiplication(state, stack);
                case "/":
                    return new Divide(state, stack);
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
                case "c":
                    return new Clear(state, stack);
                case "exit":
                    System.exit(0);
                default:
                    try {
                        return new NumericKeypad(input, state);
                    } catch (NumberFormatException e) {
                        System.out.println("Error unknown operator : " + input);
                        return null;
                    }
            }
        }
    }

    private void processInput(String input) {

        Operator operator = OperatorList.createOperator(input, state, state.getStack());

        operator.execute();
        stack.push(input);

        updateCurrentState(state.getCurrentInput());
        if (!(operator instanceof NumericKeypad)){
            stack.pop();
            operator.execute();
            stack.push(state.getCurrentInput());
        }
    }


    private void updateCurrentState(String input) {
        state.setCurrentInput(input);
    }

    public static void main(String[] args) {
        System.out.println("java calculator");
        System.out.println("HELLO");
        Calculator2 calculator = new Calculator2();
        calculator.run();
    }
}
