import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class DequeTest {

    private Deque<Integer> deque = new Deque<>();

    @Test
    public void size() {
        assertEquals(deque.size(), 0);

        deque.addFirst(1);
        assertEquals(deque.size(), 1);

        deque.addLast(2);
        assertEquals(deque.size(), 2);

        deque.removeFirst();
        assertEquals(deque.size(), 1);

        deque.removeLast();
        assertEquals(deque.size(), 0);
    }

    @Test
    public void isEmpty() {
        assertTrue(deque.isEmpty());

        deque.addFirst(1);
        assertFalse(deque.isEmpty());

    }

    @Test
    public void addAndRemoveFirst() {
        Integer one = 1;
        deque.addFirst(one);
        assertEquals(deque.removeFirst(), one);
        assertTrue(deque.isEmpty());
    }

    @Test
    public void addAndRemoveLast() {
        Integer one = 1;
        deque.addLast(one);
        assertEquals(deque.removeLast(), one);
        assertTrue(deque.isEmpty());
    }

    @Test
    public void addAndRemoveLastTwice() {
        Integer one = 1;
        Integer two = 2;
        deque.addLast(one);
        deque.addLast(two);
        assertEquals(deque.removeLast(), two);
        assertEquals(deque.removeLast(), one);
    }

    @Test
    public void addAndRemoveFirstTwice() {
        Integer one = 1;
        Integer two = 2;
        deque.addFirst(one);
        deque.addFirst(two);
        assertEquals(deque.removeFirst(), two);
        assertEquals(deque.removeFirst(), one);
    }

    @Test
    public void addFirstRemoveLast() {
        Integer one = 1;
        Integer two = 2;
        deque.addFirst(one);
        deque.addFirst(two);
        assertEquals(deque.removeLast(), one);
        assertEquals(deque.removeLast(), two);
    }

    @Test
    public void addLastRemoveFirst() {
        Integer one = 1;
        Integer two = 2;
        deque.addLast(one);
        deque.addLast(two);
        assertEquals(deque.removeFirst(), one);
        assertEquals(deque.removeFirst(), two);
    }


    @Test(expected = IllegalArgumentException.class)
    public void cantAddLastWithNull() {
        deque.addLast(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cantAddFirstWithNull() {
        deque.addFirst(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void cantRemoveLastIfEmpty() {
        deque.removeLast();
    }

    @Test(expected = NoSuchElementException.class)
    public void cantRemoveFirstIfEmpty() {
        deque.removeFirst();
    }

    @Test
    public void iterator() {
        deque.addFirst(1);
        deque.addFirst(3);
        deque.addFirst(5);
        List<Object> values = new ArrayList<>();
        deque.iterator().forEachRemaining(values::add);
        assertArrayEquals(values.toArray(), Arrays.asList(5,3,1).toArray());
    }


    @Test(expected = NoSuchElementException.class)
    public void cantCallNextOnEmptyIterator() {
        deque.iterator().next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void dontSupportRemoveOperation() {
        deque.iterator().remove();
    }
}