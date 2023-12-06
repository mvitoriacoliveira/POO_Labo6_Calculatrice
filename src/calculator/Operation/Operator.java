package calculator.Operation;

import calculator.util.State;

/**
 * An abstract class representing an operator in a calculator.
 * Operators perform various operations on the calculator state.
 * This class is designed to be extended by specific operator implementations.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 */
public abstract class Operator {

  /* The operator instance. */
  public Operator operator;

  /* The state of the calculator. */
  public State state;

  /**
   * Constructs an Operator with the given calculator state.
   * @param s The state of the calculator.
   */
  public Operator(State s){
    state = s;
  }

  /* Executes the operation associated with the operator. */
  public abstract void execute();

  /**
   * Checks if the calculator is in an error state.
   * @return true if the calculator is in an error state, false otherwise.
   */
  protected boolean ErrorState() {
    return state.isError();
  }
}
