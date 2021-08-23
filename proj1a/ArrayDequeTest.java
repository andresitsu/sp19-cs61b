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
        a.addLast("9");
        a.addFirst("0-1");

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
    public void startingByLast() {
        ArrayDeque<Integer> a = new ArrayDeque<Integer>();
        a.addLast(1);
        a.addLast(2);
        a.addFirst(0);

        int m = a.get(0);
        assertEquals(0, m);
    }

    @Test
    public void ensureResizeSafe() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        for (int i = 0; i <= 100; i += 1) {
            if (i % 2 == 0) {
                a.addFirst(i);
            } else {
                a.addLast(i);
            }
        }
        a.printDeque();
    }

    @Test
    public void randomAddandRemove(){
        ArrayDeque<Integer> a = new ArrayDeque<>();
        for (int i = 0; i <= 3; i += 1) {
            a.addFirst(i);
        }
        for (int i = 0; i <= 2; i += 1) {
            a.removeLast();
        }
        for (int i = 0; i <= 1; i += 1) {
            a.removeFirst();
        }
        assertEquals(true, a.isEmpty());
        for (int i = 0; i <= 4; i += 1) {
            a.addLast(i);
        }
        a.printDeque();
    }
}
