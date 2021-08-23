import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayDequeTest {
    @Test
    /** a general test of getRecursive. */
    public void testAddingAndGetting() {
        ArrayDeque<String> a = new ArrayDeque<String>();
        a.addFirst("3");
        a.addLast("4");
        a.addFirst("2");
        a.addLast("5");
        a.addFirst("1");
        a.addFirst("0");
        a.addLast("6");
        a.addLast("7");
        a.addLast("8");

        String expectedOne = "1";
        String getOne = a.get(1);
        assertEquals(expectedOne, getOne);

        Boolean expectedEmpty = a.isEmpty();
        assertEquals(false, expectedEmpty);

        assertEquals(a.size(), 9);

        a.printDeque();
    }

    @Test
    public void testRemoveLast() {
        ArrayDeque<String> a = new ArrayDeque<String>();
        a.addFirst("3");
        a.addLast("4");
        a.addFirst("2");
        a.addLast("5");
        a.addFirst("1");
        a.addFirst("0");
        a.addLast("6");
        a.addLast("7");
        a.addLast("8");

        String m = a.removeLast();
        assertEquals(8, a.size());
        assertEquals("8", m);

        a.removeLast();
        a.removeLast();
        a.removeLast();
        a.addLast("New Last");
        assertEquals("New Last", a.getLast());
    }

    @Test
    public void testRemoveFirst() {
        ArrayDeque<String> a = new ArrayDeque<String>();
        a.addFirst("3");
        a.addLast("4");
        a.addFirst("2");
        a.addLast("5");
        a.addFirst("1");
        a.addFirst("0");
        a.addLast("6");
        a.addLast("7");
        a.addLast("8");

        String m = a.removeFirst();
        assertEquals(8, a.size());
        assertEquals("0", m);

        a.removeLast();
        a.removeLast();
        a.removeLast();
        a.addFirst("New First");
        assertEquals("New First", a.get(0));
    }

    @Test
    public void testDeepCopy() {
        ArrayDeque<String> a = new ArrayDeque<String>();
        a.addFirst("3");
        a.addLast("4");
        a.addFirst("2");
        a.addLast("5");
        a.addFirst("1");
        a.addFirst("0");
        a.addLast("6");
        a.addLast("7");
        a.addLast("8");

        ArrayDeque<String> b = new ArrayDeque(a);
        a.removeLast();

        b.printDeque();
    }

    @Test
    public void startingByLast() {
        ArrayDeque<Integer> a = new ArrayDeque<Integer>();
        a.addLast(1);
        a.addLast(2);
        a.addFirst(0);

        int m = a.get(0);
        assertEquals(0, m);
    }
}
