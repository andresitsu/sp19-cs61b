import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListDequeMyTest {
    @Test
    /** a general test of getRecursive. */
    public void testGetRecursive() {
        LinkedListDeque<String> a = new LinkedListDeque<String>("maka");
        a.addLast("faka");
        a.addLast("nasa");
        a.addLast("gaoga");
        String expected = "nasa";
        String actual = a.getRecursive(2);

        assertEquals(expected, actual);
    }


}
