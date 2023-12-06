package calculator.util;

import java.util.ArrayList;

/**
 * A generic stack implementation.
 *
 * @param <T> The type of elements stored in the stack.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 */
public class Stack<T> {
    private Node<T> top;
    private int size = 0;


   public  Stack(T e, Stack<T> oldS) {
        this.top = new Node<>(e, oldS.top);
        ++size;
    }
    public Stack(T e) {
        this(e, null);
    }
    public Stack() {
        this.top = null;
    }

    public void push(T e) {
        this.top = new Node<>(e, this.top);
        ++this.size;
    }

    public T pop() {
        if (this.isEmpty()) {
            throw new NullPointerException("This stack is empty");
        }
        T data = this.top.data;
        this.top = this.top.next;
        --this.size;

        return data;
    }

    public void clear() {
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty(){
       return this.size == 0;
    }

    public int getSize(){
       return this.size;
    }

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

    public Object[] toArray(){
        ArrayList<T> tab = new ArrayList<>();
        Iterator<T> it = new Iterator<>(this.top);

        while (it.hasNext()) {
            tab.add(it.next());
        }

        return tab.toArray();
    }

    public Iterator<T> iterator(){
        return new Iterator<>(this.top);
    }
}
