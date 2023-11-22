package calculator.Operation;


public abstract class Operator
{
  public static <T extends Number> double convertDouble(T value){
    return value.doubleValue();
  }
  //public abstract double execute(double op1);
  public abstract double execute(double op1);
  public abstract double execute(double op1, double op2);

}
