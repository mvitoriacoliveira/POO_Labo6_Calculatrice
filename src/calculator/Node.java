package calculator;

/**
 * Represents a node in a linked list.
 *
 * @author Vitoria Oliveira
 * @author Camille Koestli
 * @since 05.12.23
 */
public class Node<T>{
    T data;
    Node<T> next;
    Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
    }
    Node(T data){
        new Node<T>(data, null);
    }
}
