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
        return null;
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
        return false;
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
