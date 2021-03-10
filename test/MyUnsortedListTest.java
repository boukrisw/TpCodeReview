/**
 * AUTHORS: BUOKRIS Walid, SBAIHIA Nassim
 */

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyUnsortedListTest {

    private MyUnsortedList<Integer> list;

    // before each Test, list is rseted
    @Before
    public void initList() {
        list = MyUnsortedList.of();
    }

    @Test
    public void testCreatList() {
        assertEquals("Creat list test using constructor", 0, list.size());

        list = MyUnsortedList.of(1, 2, 3, 4, 5);
        assertEquals("Creat list test using of() pattern", 5, list.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue("isEmpty() test on an empty List",list.isEmpty());
        list.append(0);
        assertFalse("isEmpty() test on an non-empty List", list.isEmpty());
    }

    @Test
    public void testSize() {
        MyUnsortedList<Integer> emptyList = MyUnsortedList.of();
        MyUnsortedList<Integer> twoElementsList = MyUnsortedList.of(1, 2);

        assertEquals("size() test on an empty List",0, emptyList.size());
        assertEquals("size() test on a 2 elements List", 2, twoElementsList.size());
    }

    @Test
    public void testPrepend() {
        list.prepend(0);
        assertFalse(list.isEmpty());
        assertEquals("prepend() Test element is add", 1, list.size());
        assertEquals("prepend() test on a Empty List", (Integer) 0, (Integer)list.pop());
    }

    @Test
    public void testAppend() {
        list.append(0);
        assertFalse(list.isEmpty());
        assertEquals("prepend() Test element is add", 1, list.size());
        assertEquals("prepend() test on a Empty List", (Integer) 0, (Integer)list.popLast());
    }

    @Test
    public void testInsert() {
        list = MyUnsortedList.of(2, 3, 5);
        list.insert(1, 0);
        assertEquals("inset() Test at the begining", (Integer)1, list.remove(0));
        list.insert(6, 3);
        assertEquals("inset() Test at the end", (Integer)6, list.remove(3));
        list.insert(4, 2);
        assertEquals("inset() Test in the mid", (Integer)4, list.remove(2));
    }

    @Test(expected = EmptyListException.class)
    public void testPopException() {
        // Exception test on an emptyList
        list.pop();
    }
    @Test
    public void testPop() {
        // Exception test on an emptyList
        list.pop();

        // test on a non-empty list
        list = MyUnsortedList.of(1, 2, 3, 4, 5);
        assertEquals("pop() test on a non-empty list", (Integer) 1, list.pop());
    }

    @Test(expected = EmptyListException.class)
    public void testPopLastException() {
        // Exception test on an emptyList
        list.popLast();
    }

    @Test
    public void testPopLast() {
        // test on a non-empty list
        list = MyUnsortedList.of(1, 2, 3, 4, 5);
        assertEquals("popLast() test on a non-empty list", (Integer) 5, list.popLast());
    }

    @Test(expected = EmptyListException.class)
    public void testRemoveEmptyList() {
        list.remove(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveInvalidPos() {
        list = MyUnsortedList.of(1, 2, 3, 4, 5);
        list.remove(7);
    }

    @Test
    public void testRemove() {
        list = MyUnsortedList.of(1, 2, 3, 4, 5);
        assertEquals("remove() test mid (3nd) element of a non-empty list", (Integer) 3, list.remove(2));
        assertEquals("remove() test first element of a non-empty list", (Integer) 1, list.remove(0));
        assertEquals("remove() test last element of a non-empty list", (Integer) 5, list.remove(list.size()-2));
    }

    @Test
    public void testEquals() {
        list = MyUnsortedList.of(1, 2, 3, 4, 5);
        assertTrue("equals() test on equals lists", list.equals(MyUnsortedList.of(1, 2, 3, 4, 5)));
        assertFalse("equals() test on non-equals lists", list.equals(MyUnsortedList.of(1, 2, 3, -4, 5)));
        assertFalse("equals() test with an empty lists", list.equals(MyUnsortedList.of()));
    }

    @Test
    public void testToString() {
        assertEquals("toString() test", list.toString(), "MyUnsortedList { size = 0, [] }");
        list = MyUnsortedList.of(1, 2, 3, 4, 5);
        assertEquals("toString() test", list.toString(), "MyUnsortedList { size = 5, [1, 2, 3, 4, 5] }");
    }
}