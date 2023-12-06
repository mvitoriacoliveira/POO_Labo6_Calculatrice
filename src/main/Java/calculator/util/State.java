package Java.calculator.util;

/**
 * Represents the state of a calculator, including the stack, current input, error information and current valiue in memory.
 * It provides a snapshot of the calculator's state, allowing manipulation and retrieval of important data during calculations.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 */
public class State {
    /* The stack that holds numerical values during calculations. */
    private Stack<Double> stack = new Stack<Double>();
    /* The current input being processed by the calculator. */
    private String currentInput;
    /* Flag indicating whether an error has occurred during the calculation. */
    private boolean error;
    /* The value stored in memory for later retrieval or manipulation. */
    private String memory;


    /**
     * Constructs a new calculator state with the specified initial input.
     * @param input The initial input for the calculator.
     */
    public State(String input){
        this.currentInput = input;
    }
    /**
     * Constructs a new calculator state with an empty initial input.
     */
    public State(){
        this("");
    }

    /* Getters & Setters for State class attributs. */
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

    /**
     * Returns a string representation of the calculator's stack.
     * @return A string representation of the stack.
     */
    public String toString() {
        return (getStack().toString());
    }
}
