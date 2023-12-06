package calculator.util;

import calculator.util.Stack;

/**
 * Represents the state of a calculator, including the stack, current input, and error information.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 */
public class State {
    private Stack<Double> stack = new Stack<Double>();
    private String currentInput;
    private boolean error;
    private String memory;

    public State(String input){
        this.currentInput = input;
    }

    public State(){
        this("");
    }
    public Stack<Double> getStack(){
        return this.stack;
    }

    public void setStack(Stack<Double> stack) {
        this.stack = stack;
    }

    public String getCurrentInput(){
        return  this.currentInput;
    }

    public void setCurrentInput(String currentInput){
        this.currentInput = currentInput;
    }

    public String getMemory() {return this.memory;}

    public void setMemory(String value) { this.memory = value;}

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
    public String toString() {
        return (getStack().toString());
    }
}
