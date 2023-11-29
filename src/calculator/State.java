package calculator;

public class State {
    private Stack<Double> stack = new Stack<Double>();
    private Double currentInput;

    public Stack<Double> getStack(){
        return this.stack;
    }

    public Double getCurrentInput(){
        Double ret = this.currentInput;
        stack.pop();
        //mettre this.currentInput = derniere valeur de la stack? TODO
        return ret;
    }

    public void setCurrentInput(Double currentInput){
        this.currentInput = currentInput;
        stack.push(currentInput);
    }

}
