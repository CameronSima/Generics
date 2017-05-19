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

    /* add element to specified index. If index is larger than size,
     throw IndexOutOfBounds. Expand capacity if needed, then copy
     contents and new index into new array.
     */

    public void add(int i, E el) throws IndexOutOfBoundsException {

        if (i <= size) {
            if (i <= capacity) {
                capacity++;
            }
            Object[] newArr = new Object[capacity];
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

    public Object get(int i) throws IndexOutOfBoundsException {
        return contents[i];
    }

    public boolean remove(E el) {

        if (contains(el)) {

            int index = indexOf(el);
            Object[] newArr = new Object[capacity];
            Object[] front = Arrays.copyOfRange(contents, 0, index);
            Object[] end = Arrays.copyOfRange(contents, index + 1, contents.length);
            System.arraycopy(front, 0, newArr, 0, front.length);
            System.arraycopy(end, 0, newArr, front.length, end.length);
            contents = newArr;
            size--;

            return true;
        } else {
            return false;
        }
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

        for (Object element : contents) {

            //ignore null values (empty capacity at the end of the array)
            if (element == null) {
                break;
            }
            if (element.equals(el)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E el) {
        for (int i = 0; i < contents.length; i++) {
            if (contents[i].equals(el)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }
}
