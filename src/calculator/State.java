package calculator;

public class State {
    private Stack<Double> stack = new Stack<Double>();
    private String currentInput;

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

    //getDoubleAsString();
    //getCurrentAsDouble();

}
