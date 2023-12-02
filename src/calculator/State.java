package calculator;

public class State {
    private Stack<Double> stack = new Stack<Double>();
    private String currentInput;

    private boolean error;
    private String errorMessage;
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

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String toString() {
        return ("current state : " + currentInput + " current stack : " + getStack().toString());
    }
}
