package Java.calculator.util;

/**
 * The Iterator class is an iterator implementation for traversing elements in a linked list.
 * It provides methods to check if there is a next element and retrieve the next element.
 * The iterator is initialized with a starting node, and it moves through the list until the end.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 */
public class Iterator<T> {
    private Node<T> current;

    public Iterator(Node<T> elem){
        this.current = elem;
    }

    public boolean hasNext(){
        //Returns false if next is null OR this is null
        return current != null;
    }

    public T next(){
        if(current == null){
            throw new NullPointerException("This stack is empty :(");
        }
        T data = current.data;
        current = current.next;
        return data;
    }
}
