public class ArrayList implements Listable {
    private Object[] data;
    private int head;
    private int tail;
    private int numberElements;

    public ArrayList() {
        this(10);
    }

    public ArrayList(int lenght) {
        data = new Object[lenght];
        head = 0;
        tail = -1;
        numberElements = 0;
    }

    @Override
    public boolean isEmpty() {
        return numberElements == 0;
    }

    @Override
    public boolean isFull() {
        return numberElements == data.length;
    }

    @Override
    public String print() {
        String result = "[";
        int aux = head;
        for (int i = 0; i < numberElements; i++) {
            result += data[aux];
            aux = next(aux);

            if (i != numberElements - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }

    @Override
    public void append(Object data) {
        if (isFull()) {
            System.err.println("List is full!");
        } else {
            tail = next(tail);
            this.data[tail] = data;
            numberElements++;
        }
    }

    @Override
    public void update(Object data, int LogicalIndex) {
        Object temp = null;
        if (isEmpty()) {
            System.err.println("List is empty!");
        } else {
            if (LogicalIndex < 0 || LogicalIndex > numberElements - 1) {
                System.err.println("Invalid Index");
            } else {
                int physicalIndex = map(LogicalIndex);
                this.data[physicalIndex] = data;
            }
        }

    }

    @Override
    public Object[] selectAll() {
        Object[] result = new Object[numberElements];
        int aux = head;
        for (int i = 0; i < numberElements; i++) {
            result[i] = data[aux];
            aux = next(aux);
        }
        return result;
    }

    @Override
    public Object select(int LogicIndex) {
        Object temp = null;
        if (isEmpty()) {
            System.err.println("List is Empty!");
        } else {
            if (LogicIndex < 0 || LogicIndex > numberElements - 1) {
                System.err.println("Invalid index");
            } else {
                int physicalIndex = map(LogicIndex);
                temp = data[physicalIndex];
            }
        }
        return temp;
    }

    private int map(int index) {
        return (head + index) % data.length;
    }

    @Override
    public void clear() {
        head = 0;
        tail = -1;
        numberElements = 0;
    }

    private int prior(int index) {
        return (index - 1 + data.length) % data.length;
    }

    private int next(int index) {
        return (index + 1) % data.length;
    }
}