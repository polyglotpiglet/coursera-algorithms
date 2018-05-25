import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class RandomizedQueueTest {

    private final RandomizedQueue<Integer> q = new RandomizedQueue<>();

    @Test
    public void size() {
        assertEquals(q.size(), 0);
        q.enqueue(1);
        assertEquals(q.size(), 1);
        q.enqueue(2);
        assertEquals(q.size(), 2);
        q.enqueue(3);
        assertEquals(q.size(), 3);
        q.enqueue(4);
        assertEquals(q.size(), 4);
    }

    @Test
    public void isEmpty() {
        assertTrue(q.isEmpty());
        q.enqueue(1);
        assertFalse(q.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void cantEnqueueNull() {
        q.enqueue(null);
    }

    @Test
    public void dequeue() {
        Integer one = 1;
        q.enqueue(one);
        assertEquals(q.dequeue(), one);
    }

    @Test
    public void dequeueDecrementsSize() {
        q.enqueue(1);
        q.dequeue();
        assertEquals(q.size(), 0);
    }

    @Test(expected = NoSuchElementException.class)
    public void cantDequeueEmpty() {
        q.dequeue();
    }

    @Test(expected = NoSuchElementException.class)
    public void cantSampleEmpty() {
        q.sample();
    }

    @Test
    public void sampleWorkManyTimes() {
        Integer one = 1;
        q.enqueue(one);
        assertEquals(q.sample(), one);
        assertEquals(q.sample(), one);
        assertEquals(q.sample(), one);
        assertEquals(q.sample(), one);
        assertEquals(q.sample(), one);
        assertEquals(q.sample(), one);
        assertEquals(q.sample(), one);
        assertEquals(q.sample(), one);
        assertEquals(q.sample(), one);
        assertEquals(q.sample(), one);
        assertEquals(q.sample(), one);
        assertEquals(q.sample(), one);
        assertEquals(q.sample(), one);
        assertEquals(q.sample(), one);
        assertEquals(q.sample(), one);
    }

    @Test
    public void iterator() {
        IntStream.range(0, 1000).forEach(q::enqueue);
        List<Integer> first = toList();
        List<Integer> second = toList();
        assertNotEquals(first, second);
    }

    private List<Integer> toList() {
        List<Integer> items = new ArrayList<>();
        q.iterator().forEachRemaining(items::add);
        return items;
    }

    @Test(expected = NoSuchElementException.class)
    public void cantCallNextOnEmptyIterator() {
        q.iterator().next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void dontSupportRemoveOperation() {
        q.iterator().remove();
    }


}