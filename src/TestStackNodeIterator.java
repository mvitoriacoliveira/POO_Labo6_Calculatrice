
import calculator.JCalculator;
import calculator.*;


public class TestStackNodeIterator {
    public static void main(String ... args) {
        new JCalculator();

    System.out.println("\n---------START TEST STACK, NODE, ITERATOR IMPLEMENTATION---------");

    Stack<Integer> stack = new Stack<>();
    Object[] tab = stack.toArray();
    System.out.println("Stack content: " + stack);

    stack.push(1);
    stack.push(2);
    stack.push(3);

    System.out.println("Stack content: " + stack);
    System.out.println("Stack content as array: " + stack);

    int poppedItem = stack.pop();
    System.out.println("Popped item: " + poppedItem);
    System.out.println("Stack content after pop: " + stack);

    Iterator<Integer> iterator = stack.iterator();
    System.out.println("Using iterator to examine the stack:");
    while (iterator.hasNext()) {
      int item = iterator.next();
      System.out.println("Examined item: " + item);
    }
    System.out.println("Stack content: " + stack);

    System.out.println("\n--------- END---------");

    }
}
