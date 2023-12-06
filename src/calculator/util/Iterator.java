package calculator.util;

/**
 * The Iterator class is an iterator implementation for traversing elements in a linked list.
 * It provides methods to check if there is a next element and retrieve the next element.
 * The iterator is initialized with a starting node, and it moves through the list until the end.
 *
 * @param <T> The type of elements in the linked list
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 */
public class Iterator<T> {
    /* The current node in the linked list. */
    private Node<T> current;

    /**
     * Constructs an iterator with the specified starting node.
     * @param elem The starting node for the iterator.
     */
    public Iterator(Node<T> elem){
        this.current = elem;
    }

    /**
     * Checks if there is a next element in the linked list.
     * @return True if there is a next element, false otherwise.
     */
    public boolean hasNext(){
        //Returns false if next is null OR this is null
        return current != null;
    }

    /**
     * Retrieves the next element from the linked list.
     * @return The next element in the linked list.
     * @throws NullPointerException If the iterator is at the end of the list.
     */
    public T next(){
        if(current == null){
            throw new NullPointerException("This stack is empty :(");
        }
        T data = current.data;
        current = current.next;
        return data;
    }
}
