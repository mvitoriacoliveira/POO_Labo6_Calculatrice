package calculator;

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

    // TODO destructor?
}
