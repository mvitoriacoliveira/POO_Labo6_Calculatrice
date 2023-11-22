package calculator.Operation;

public abstract class Operator<T> {
  public static <T extends Number> double convertDouble(T value) {
    return value.doubleValue();
  }

  public abstract T execute(T op1);

  public abstract T execute(T op1, T op2);
}