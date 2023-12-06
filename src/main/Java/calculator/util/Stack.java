package Java.calculator.util;

import java.util.ArrayList;

/**
 * A generic stack implementation.
 *
 * This class represents a generic stack that can hold elements of a specified type.
 * It supports standard stack operations such as push, pop, clear, and provides methods
 * to check if the stack is empty, get its size, convert it to an array, and obtain an iterator.
 *
 * @param <T> The type of elements stored in the stack.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 */
public class Stack<T> {
    /* The top of the stack. */
    private Node<T> top;
    /* The size of the stack. */
    private int size = 0;


    /**
     * Constructs a stack with the specified element and a reference to an old stack.
     * @param e    The element to be added to the stack.
     * @param oldS The old stack to be referenced.
     */
    public  Stack(T e, Stack<T> oldS) {
        this.top = new Node<>(e, oldS.top);
        ++size;
    }

    /**
     * Constructs a stack with the specified element.
     * @param e The element to be added to the stack.
     */
    public Stack(T e) {
        this(e, null);
    }

    /**
     * Constructs an empty stack.
     */
    public Stack() {
        this.top = null;
    }

    /**
     * Pushes an element onto the stack.
     * @param e The element to be pushed onto the stack.
     */
    public void push(T e) {
        this.top = new Node<>(e, this.top);
        ++this.size;
    }

    /**
     * Pops the top element from the stack.
     * @return The popped element.
     * @throws NullPointerException If the stack is empty.
     */
    public T pop() {
        if (this.isEmpty()) {
            throw new NullPointerException("This stack is empty");
        }
        T data = this.top.data;
        this.top = this.top.next;
        --this.size;

        return data;
    }

    /**
     * Clears the stack, removing all elements.
     */
    public void clear() {
        this.top = null;
        this.size = 0;
    }

    /**
     * Checks if the stack is empty.
     * @return True if the stack is empty, false otherwise.
     */
    public boolean isEmpty(){
        return this.size == 0;
    }

    /**
     * Gets the size of the stack.
     * @return The size of the stack.
     */
    public int getSize(){
        return this.size;
    }

    /**
     * Returns a string representation of the stack.
     * @return A string representation of the stack.
     */
    public String toString(){
        StringBuilder ret = new StringBuilder("[");
        Iterator<T> it = new Iterator<>(this.top);
        int i = 0;
        while (it.hasNext()){
            if(i > 0){
                ret.append(", ");
            }
            ++i;
            ret.append(it.next());
        }

        return ret.append("]").toString();
    }

    /**
     * Converts the stack to an array.
     * @return An array containing the elements of the stack.
     */
    public Object[] toArray(){
        ArrayList<T> tab = new ArrayList<>();
        Iterator<T> it = new Iterator<>(this.top);

        while (it.hasNext()) {
            tab.add(it.next());
        }

        return tab.toArray();
    }

    /**
     * Returns an iterator for the stack.
     * @return An iterator for the stack.
     */
    public Iterator<T> iterator(){
        return new Iterator<>(this.top);
    }
}

