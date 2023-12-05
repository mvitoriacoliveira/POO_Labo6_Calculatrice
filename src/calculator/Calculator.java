package calculator;

import calculator.Operation.*;

import java.util.Scanner;

import static calculator.Formatter.formatOneDecimal;

public class Calculator {
    private State state;
    private Stack stack;

    public Calculator() {
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

            System.out.println(state);
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
                    stack.pop();
                    return new MemoryStore(state);
                case "<=":
                    stack.pop();
                    return new Backspace(state);
                case "ce":
                    stack.pop();
                    return new ClearError(state);
                case "c":
                    stack.pop();
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
        stack.push(formatOneDecimal(input));

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
    }

    public static void main(String[] args) {
        System.out.println("java calculator");
        Calculator calculator = new Calculator();
        calculator.run();
    }
}
