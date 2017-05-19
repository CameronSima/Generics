import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by cameronsima on 5/19/17.
 */
public class MySetTests {

    @Test
    public void addElementNotInSetTest() {
        MySet<String> set = new MySet<>();
        set.add("a");
        set.add("b");

        Assert.assertEquals(2, set.size());
    }

    @Test
    public void addDuplicateInSetTest() {
        MySet<String> set = new MySet<>();
        set.add("a");
        set.add("b");

        Assert.assertFalse(set.add("b"));
    }

    @Test
    public void addElementToIndexTest() {
        MySet<String> set = new MySet<>();
        set.add("a");
        set.add("b");
        set.add("d");

        set.add(2, "c");
    }

    @Test
    public void addDuplicateToIndexTest() {
        MySet<String> set = new MySet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");

        Assert.assertFalse(set.add(2, "c"));
    }

    @Test
    public void addAllNoDuplicatesTest() {
        MySet<String> set = new MySet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");

        ArrayList<String> newCollection = new ArrayList<>();
        newCollection.add("e");
        newCollection.add("f");
        newCollection.add("g");

        Assert.assertTrue(set.addAll(newCollection));
        Assert.assertEquals("f", set.get(5));
        Assert.assertEquals(7, set.size());

    }

    @Test
    public void addAllWithDuplicatesTest() {
        MySet<String> set = new MySet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");

        ArrayList<String> newCollection = new ArrayList<>();
        newCollection.add("c");
        newCollection.add("d");
        newCollection.add("g");

        Assert.assertTrue(set.addAll(newCollection));
        Assert.assertEquals("g", set.get(4));
        Assert.assertEquals(5, set.size());

    }

    @Test
    public void addAllSetDoesntChangeTest() {
        MySet<String> set = new MySet<>();
        set.add("a");
        set.add("b");
        set.add("c");

        ArrayList<String> newCollection = new ArrayList<>();
        newCollection.add("a");
        newCollection.add("b");
        newCollection.add("c");

        Assert.assertFalse(set.addAll(newCollection));
        Assert.assertEquals("c", set.get(2));
        Assert.assertEquals(3, set.size());
    }




}
