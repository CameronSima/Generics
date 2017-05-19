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

    public void add(int i, E el) throws IndexOutOfBoundsException {

        if (i <= size) {

            Object[] newArr = new Object[contents.length + 1];
            Object[] front = Arrays.copyOfRange(contents, 0, i);
            Object[] end = Arrays.copyOfRange(contents, i, contents.length);
            System.arraycopy(front, 0, newArr, 0, front.length);
            newArr[i] = el;
            System.arraycopy(end, 0, newArr, front.length + 1, end.length);
            contents = newArr;
            size++;

        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public Object get(int i) {
        return contents[i];
    }

    public void remove() {

    }

    public void set(int i, E el) throws IndexOutOfBoundsException {

        if (i <= size) {
            contents[i] = el;
        }
        else {
            throw new IndexOutOfBoundsException();
        }

    }

    public void clear() {
        contents = new Object[1];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E el) {
        return true;
    }

    public int size() {
        return size;
    }
}