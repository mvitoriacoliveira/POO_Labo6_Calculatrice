package Java.calculator.util;

/**
 * Represents a node in a linked list.
 *
 * @param <T> The type of data stored in the node.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 */
public class Node<T>{
    /* The data stored in the node. */
    T data;
    /* The reference to the next node in the linked list. */
    Node<T> next;

    /**
     * Constructs a node with the specified data and reference to the next node.
     * @param data The data to be stored in the node.
     * @param next The reference to the next node in the linked list.
     */
    Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
    }
    /**
     * Constructs a node with the specified data and a null reference to the next node.
     * @param data The data to be stored in the node.
     */
    Node(T data){
        new Node<T>(data, null);
    }
}
