package calculator;

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
