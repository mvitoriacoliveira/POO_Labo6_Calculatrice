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

            switch (input) {
                case "+":
                    stack.pop();
                    return new Addition(state, stack);
                case "-":
                    stack.pop();
                    return new Subtraction(state, stack);
                case "*":
                    stack.pop();
                    return new Multiplication(state, stack);
                case "/":
                    stack.pop();
                    return new Divide(state, stack);
                case "sqrt":
                    stack.pop();
                    return new SquareRoot(state);
                case "x^2":
                    stack.pop();
                    return new Squared(state);
                case "1/x":
                    stack.pop();
                    return new Inverse(state);
                case "-/+":
                    stack.pop();
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

        stack.push(input);

        if (!(operator instanceof NumericKeypad)){
            stack.pop();
            operator.execute();

            double result = Double.parseDouble(state.getCurrentInput());
            stack.push(state.getCurrentInput());

            state.setCurrentInput(String.valueOf(result));
        }
        else {
            operator.execute();
            state.setCurrentInput(input);
        }
        System.out.println("State : " + state);
        System.out.println("Current input : " + state.getCurrentInput());
    }

    public static void main(String[] args) {
        System.out.println("java calculator");
        Calculator2 calculator = new Calculator2();
        calculator.run();
    }
}
