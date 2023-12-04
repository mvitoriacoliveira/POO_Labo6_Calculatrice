package calculator.Operation;

import calculator.State;

public abstract class Operator {

  public Operator operator;

  public State state;

  public Operator(State s){
    state = s;
  }

  public abstract void execute();

  protected boolean ErrorState() {
    return state.isError();
  }
}