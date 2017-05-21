import java.util.Collection;
import java.util.Set;

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


    public boolean containsAll(Collection<?> coll) {

        return Ehelper(coll);
//        boolean hasAll = true;
//
//        for (Object el: coll) {
//            if (!super.contains(el)) {
//                hasAll = false;
//            }
//        }
//        return hasAll;
    }

//    private boolean Ehelper(Collection<E> coll) {
//
//        boolean hasAll = true;
//
//        for (E el : coll) {
//            if (!super.contains(el)) {
//                hasAll = false;
//            }
//        }
//        return hasAll;
//    }

    @Override
    public boolean equals(Object o) {

        boolean isEqual = true;

        if (!(o instanceof Set)) {
            return false;
        } else {
            for (Object el: (Collection) o) {
                System.out.println(el);
//                if (!el.equals(o)) {
//
//                    isEqual = false;
//                }
            }
        }

    return isEqual;
    }


}
