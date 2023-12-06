package Java;

import Java.calculator.util.State;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import Java.calculator.util.*;

public class TestStackNodeIterator {

    @Test
    public void testStackOperations() {
        // Test the basic stack operations (push, pop, clear)
        Stack<Integer> stack = new Stack<>();

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.getSize());

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertFalse(stack.isEmpty());
        assertEquals(3, stack.getSize());

        assertEquals(3, (int) stack.pop());
        assertEquals(2, stack.getSize());

        stack.clear();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.getSize());
    }

    @Test
    public void testStateOperations() {
        // Test basic state operations
        State state = new State("5");

        assertEquals("5", state.getCurrentInput());
        assertFalse(state.isError());

        state.setCurrentInput("10");
        assertEquals("10", state.getCurrentInput());

        state.setError(true);
        assertTrue(state.isError());

        state.setError(false);
        assertFalse(state.isError());
    }

    @Test
    public void testIterator() {
        // Test the iterator functionality
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        StringBuilder result = new StringBuilder();
        Iterator<Integer> it = stack.iterator();
        int i = 0;
        while (it.hasNext()) {
            ++i;
            result.append(it.next());
        }
        assertEquals("321", result.toString());
    }

    @Test
    public void testPopEmptyStack() {
        assertThrows(NullPointerException.class, () -> {
            Stack<Integer> stack = new Stack<>();
            stack.pop();
        });
    }

    // Add more tests for other functionalities and error handling as needed

}
