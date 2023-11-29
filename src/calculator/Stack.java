package calculator;
import java.util.ArrayList; //ArrayList for current Stack state

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

    public Object[] currentState(){
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

    /*
    - obtenir la représentation sous la forme de chaîne de caractères du contenu de la pile ;
    - obtenir un tableau d’objets représentant l’état actuel de la pile (l’indice 0 contenant l’élément placé au sommet de la pile) ;
    - obtenir un itérateur sur la pile offrant les opérations T next() et boolean hasNext().
    */
}
