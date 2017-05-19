import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by cameronsima on 5/18/17.
 */
public class MyArrayListTests {

    @Test(expected = IndexOutOfBoundsException.class)
    public void getOutOfBoundsTest() {
        MyArrayList<String> list = new MyArrayList();

        list.get(5);
    }

    @Test
    public void setStringTest() {

        MyArrayList<String> list = new MyArrayList();
        list.add("Hello");

        // list has 1 object
        Assert.assertEquals(1, list.size());

        // String at index 0 is "Hello"
        Assert.assertEquals("Hello", list.get(0));
    }

    @Test
    public void setIntTest() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);

        // list has 1 object
        Assert.assertEquals(1, list.size());

        // int at index 0 is 1
        Assert.assertEquals(1, list.get(0));
    }

    @Test
    public void clearTest() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.clear();

        Assert.assertEquals(0, list.size());
    }

    @Test
    public void clearThenRepopulateTest() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.clear();
        list.add(1);

        // list has 1 element
        Assert.assertEquals(1, list.size());

        // that element is int 1
        Assert.assertEquals(1, list.get(0));
    }

    @Test
    public void indexOfTest() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // element 2 is at index 1
        Assert.assertEquals(1, list.indexOf(2));
    }

    @Test
    public void isEmptyTrueTest() {
        MyArrayList<String> list = new MyArrayList<>();

        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void isEmptyFalseTest() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Hi");

        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void populatedThenClearedIsEmptyTest() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.clear();

        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void instantiateWithArrayWithSpecifiedSize() {

        // list has capacity of 13
        MyArrayList<Integer> list = new MyArrayList<>(12);
        list.add(1);

        // list has only 1 element
        Assert.assertEquals(1, list.size());

        // int at index 0 is 1
        Assert.assertEquals(1, list.get(0));
    }

    @Test
    public void arrayNeedsToBeExpandedTest() {

        // list capacity is 1;
        MyArrayList<Integer> list = new MyArrayList<>();

        // add 3 elements;
        list.add(1);
        list.add(2);
        list.add(3);

        // list successfully expanded, has 3 elements
        Assert.assertEquals(3, list.size());

    }

    @Test
    public void addElementToIndexEmptyListSize0() {

        // list capacity is 1;
        MyArrayList<Integer> list = new MyArrayList<>();

        // add element within size
        list.add(0, 1);

        // list has 1 element
        Assert.assertEquals(1, list.size());

        // that element is int 1
        Assert.assertEquals(1, list.get(0));
    }

    @Test
    public void addElementToIndexWithExtraCapacity() {

        // list capacity is 10;
        MyArrayList<Integer> list = new MyArrayList<>(10);

        // add element within size
        list.add(0, 1);

        // list has 1 element
        Assert.assertEquals(1, list.size());

        // that element is int 1
        Assert.assertEquals(1, list.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addElementToIndexLagerThanSize() {

        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(50, 4);
    }

    @Test
    public void canAddWithIndexAtEndOfList() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("this");
        list.add("is");

        // out of bounds
        list.add(2, "a test");

        // list now has 3 things
        Assert.assertEquals(3, list.size());

        // thing at index 2 is String "a test"
        Assert.assertEquals("a test", list.get(2));
    }

    @Test
    public void addElementToIndexLessThanSize() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(3, 4);

        // Item at index 3 == 4
        Assert.assertEquals(4, list.get(3));

        // list has expanded to size == 6
        Assert.assertEquals(6, list.size());
    }

    @Test
    public void setTest() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(76);
        list.add(5);
        list.add(6);

        list.set(2, 3);

        // Item at index 2 equals 3
        Assert.assertEquals(3, list.get(2));

        // List hasn't changed size
        Assert.assertEquals(5, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setIndexOutOfBoundsTest() {

        MyArrayList<String> list = new MyArrayList<>();
        list.add("this");
        list.add("is");

        // out of bounds
        list.set(2, "a test");
    }

    @Test
    public void containsTrueTest() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("foo");

        Assert.assertTrue(list.contains("foo"));
    }

    @Test
    public void containsFalseTest() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("foo");

        Assert.assertFalse(list.contains("bar"));
    }

    @Test
    public void removeTest() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("z");
        list.add("d");
        list.add("e");

        // list has 6 elements
        Assert.assertEquals(6, list.size());

        list.remove("z");

        Assert.assertFalse(list.contains("z"));

        // list has shrunk to 5
        Assert.assertEquals(5, list.size());
    }


}
