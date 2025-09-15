public interface Listable {

    void insert(Object data, int LogicalIndex);

    void append(Object data); // feito

    Object select(int LogicIndex); // feito

    Object[] selectAll(); // feito

    void update(Object data, int LogicalIndex); // feito

    Object delete(int LogicalInde);

    void clear(); // feito

    boolean isEmpty(); // feito

    boolean isFull(); // feito

    String print(); // feito

}
