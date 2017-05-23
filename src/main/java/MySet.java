import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by cameronsima on 5/19/17.
 */
public class MySet<E> extends MyArrayList<E> implements Set<E> {

    @Override
    public boolean contains(Object o) {
        return super.contains((E) o);
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size()];

        int index = 0;
        for(Object el : getContents()) {
            result[index] = el;
            index++;
        }
        return result;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size()) {
            return (T[]) Arrays.copyOf(getContents(), size(), a.getClass());
        }
        System.arraycopy(getContents(), 0, a, 0, size());
        return a;
    }

    @Override
    public boolean remove(Object o) {
        return super.remove((E) o);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Iterator<?> iterator = c.iterator();
        int len = size() - c.size();
        boolean contains = false;

        Object[] newArr = new Object[len];

        int index = 0;
        while (iterator.hasNext()) {
            if (contains(iterator.next())) {
                contains = true;
                newArr[index] = iterator.next();
                index++;
            }
        }
        return contains;
    }

    @Override
    public boolean add(E el) {
        return !super.contains(el) && super.add(el);
    }

    @Override
    public boolean add(int i, E el) throws IndexOutOfBoundsException {
        return !super.contains(el) && super.add(i, el);
    }

    @Override
    public boolean addAll(Collection<? extends E> otherColl) {

        boolean hasChanged = false;

        for (E el : otherColl) {
            if (!super.contains(el)) {
                hasChanged = true;
                super.add(el);
            }
        }
        return hasChanged;
    }


    @Override
    public boolean containsAll(Collection<?> coll) {
        boolean hasAll = true;
        for (Object el: coll) {
            if (!super.contains((E) el)) {
                hasAll = false;
            }
        }
        return hasAll;
    }


}
