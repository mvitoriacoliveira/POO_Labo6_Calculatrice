package calculator.Operation;

import calculator.State;

public abstract class Operator<T> {

  public Operator operator;

  //public State state = new State();

  public abstract T execute();
}