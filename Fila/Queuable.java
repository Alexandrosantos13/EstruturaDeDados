public interface Queuable {
    void enqueue(Object data);
    Object dequeue();
    Object front();

    Boolean isEmpty();
    Boolean isFull();
    String print();
    
}