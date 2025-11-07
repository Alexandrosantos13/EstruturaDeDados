/**
 * Implementação de uma pilha dinâmica duplamente encadeada genérica.
 * Esta classe implementa uma pilha que pode armazenar elementos de qualquer tipo,
 * utilizando uma estrutura de nós duplamente encadeados.
 *
 * @param <T> o tipo dos elementos armazenados na pilha
 * @author Alexandro Costa Santos
 * @version 1.0.0
 * @since 2025-10-09
 */
public class LinkedStack {
    /**
     * Ponteiro para o topo da pilha
     */

    private DoubleNode<T> topPointer;
    /**
     * Quantidade atual de elementos
     */
    private int numberElements;
    /**
     * Tamanho máximo da pilha
     */
    private int maxElements;

    /**
     * Construtor padrão que cria uma pilha com capacidade para 10 elementos.
     */
    public linkedStack() {
        this(10);
    }

    public linkedStack(int maxElements) {

    }

    boolean T

    peek() {
        if (isEmpty()) {
            throw noSuchElementException("Stack is empty!")
        }
        T auxData = topPointer.getData();
        numberElements--;
        topPointer = topPointer.getPrevious();
        ropPointer.setNext(null);
        return auxData;
    }

    public push(T data) {
        if (isFull()) {
            throw noSuchElementException("Stack is full!")
        }
        DoubleNode<T> newNode = new DoubleNode<>();
        newNode.setData(data);
        topPointer.setNext(newNode)
        newNode.setPrevous(topPointer);
        topPointer = newNode;
        numberElements++;
    }
public void update(T newData){
    if (isEmpty()) {
        throw new NoSuchElementException("Pilha Vazia!");
    }
    topPointer.setData(newData);

}

}