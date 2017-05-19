import java.util.Collection;

/**
 * Created by cameronsima on 5/19/17.
 */
public class MySet<E> extends MyArrayList<E> {

    @Override
    public boolean add(E el) {
        return !super.contains(el) && super.add(el);
    }

    @Override
    public boolean add(int i, E el) throws IndexOutOfBoundsException {
        return !super.contains(el) && super.add(i, el);
    }

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
}
