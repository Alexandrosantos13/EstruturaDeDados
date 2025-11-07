public class DoubleNode<T> {
    private T data;
    private DoubleNode<T> next;
    private DoubleNode<T> previous;

    // Getter e Setter para data
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    // Getter e Setter para next
    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    // Getter e Setter para previous
    public DoubleNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }
}