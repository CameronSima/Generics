import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by cameronsima on 5/18/17.
 */
public class MyArrayListTests {

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
    public void instantiateWithArrayWithSpecifiedSize() {

        // list has capacity of 13
        MyArrayList<Integer> list = new MyArrayList<>(12);
        list.add(1);

        // list has 1 element
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
    public void addElementToIndex() {
        
    }
}
