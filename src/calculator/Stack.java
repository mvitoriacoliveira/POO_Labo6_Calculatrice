package calculator;

public class Stack<T> {
    Node<T> top;

    Stack(T e, Stack<T> oldS){
        this.top = new Node<T>(e, oldS.top);
    }
    Stack(T e){
        new Stack<T>(e, null);
    }

    void push(T e){
        this.top = new Node<T>(e, this.top);
    }

    T pop(){
        // TODO remplacer par if empty?
        if(this.top == null){
            throw new NullPointerException("This stack is empty");
        }
        T ret = this.top.data;
        this.top = this.top.next;

        return ret;
    }
}
