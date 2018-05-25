import java.util.*;

public class RandomizedQueue<T> implements Iterable<T> {


    private final List<T> items = new ArrayList<>();
    private final Random random = new Random();

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            List<T> internalItems = new ArrayList<>(items);

            @Override
            public boolean hasNext() {
                return internalItems.size() > 0;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int index = random.nextInt(internalItems.size());
                return internalItems.remove(index);
            }
        };
    }

    public int size() {
        return this.items.size();
    }

    public void enqueue(T item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        this.items.add(item);

    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public T dequeue() {
        if (this.isEmpty()){
            throw new NoSuchElementException();
        }
        int indexToRemove = random.nextInt(size());
        return this.items.remove(indexToRemove);
    }

    public T sample() {
        if (this.isEmpty()){
            throw new NoSuchElementException();
        }
        int indexToRemove = random.nextInt(size());
        return this.items.get(indexToRemove);
    }
}
