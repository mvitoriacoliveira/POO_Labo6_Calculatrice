package calculator.Operation;

import calculator.State;

/**
 * An abstract class representing an operator in a calculator.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 */
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