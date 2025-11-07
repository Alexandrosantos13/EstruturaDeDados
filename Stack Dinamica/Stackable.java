public interface Stackable<T> {

    void push(T data);
    T pop();
    T peek();
    void update(T newData);

    boolean isFull();
    boolean isEmpty();
    String print();
    
}