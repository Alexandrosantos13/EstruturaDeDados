public class ArrayStack implements Stackable {
  private Object[] data;
  private int pointerTop;

  public ArrayStack(int length) {
    this(10);
  }

  public ArrayStack(int length) {
    data = new Object[length];
    pointerTop = -1;
  }

  boolean isEmpty() {
    return pointerTop == -1;
  }
  boolean isFull() {
    return pointerTop == data.length - 1;
  }

  void pop (Object data) {
    if (!isEmpty()) {
      // posso desempilhar
    }
  }
  void push (Object data) {
    if (!isFull()) {
      // posso empilhar
    }
  }

  Object peek () {
    if (!isEmpty()) {
      return data[pointerTop];
    }
    return null;
  }
}