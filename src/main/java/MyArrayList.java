import java.util.Arrays;

/**
 * Created by cameronsima on 5/18/17.
 */
public class MyArrayList <E> {

    private Object[] contents;
    private int size;
    private int capacity;


    public MyArrayList() {
        size = 0;
        capacity = 1;
        contents = new Object[1];
    }

    public MyArrayList(int i) {
        size = 0;
        capacity = i;
        contents = new Object[capacity];
    }

    private boolean atCapacity() {
        return capacity <= size;
    }

    private void expand() {
        contents = Arrays.copyOf(contents, capacity + 1);
        capacity++;
    }


    public void add(E el) {

        if (atCapacity()) {
            expand();
        }
        contents[size] = el;
        size++;
    }

    public void add(E el, int i) throws IndexOutOfBoundsException {

        if (i < size) {
            add(el);
        } else {
            Object[] front = Arrays.copyOfRange(contents, 0, i + 1);
            front[i] = el;
            Object[] end = Arrays.copyOfRange(contents, i, contents.length);
            Object[] newArr = new Object[size + 1];
            System.arraycopy(newArr, 0, end, 0, 0);
            contents = newArr;
        }

    }

    public Object get(int i) {
        return contents[i];
    }

    public void remove() {

    }

    public void set(E el, int i) {

    }

    public void clear() {

    }

    public boolean isEmpty() {
        return true;

    }

    public boolean contains(E el) {
        return true;
    }

    public int size() {
        return size;
    }
}
