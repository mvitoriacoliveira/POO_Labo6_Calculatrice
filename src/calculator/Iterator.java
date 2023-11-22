package calculator;

public class Iterator<T> {
    private Node<T> current;

    public Iterator(Node<T> elem){
        this.current = elem;
    }

    public boolean hasNext(){
        //Returns false if next is null OR this is null
        return current != null && current.next != null;
    }

    public T next(){
        if(current == null){
            throw new NullPointerException("This stack is empty :(");
        }
        /*
        if(!this.hasNext()){
            throw new NullPointerException("There's no more elements left :(");
        }*/
        T data = current.data;
        current = current.next;
        return data;
    }
}
