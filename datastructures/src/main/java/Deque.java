import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node<Item> head;
    private Node<Item> tail;

    private int numberOfItems;

    public Deque() {
        this.numberOfItems = 0;
    }

    public int size() {
        return this.numberOfItems;
    }

    public boolean isEmpty() {
        return this.numberOfItems == 0;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node<Item> newNode = new Node<>(item);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        }

        else {
            newNode.setNext(this.head);
            this.head.setPrevious(newNode);
            this.head = newNode;
        }


        this.numberOfItems++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (this.tail == null) {
            addFirst(item);
        }
        else {
            Node<Item> newNode = new Node<>(item);
            this.head.setNext(newNode);
            newNode.setPrevious(this.head);
            this.tail = newNode;
            this.numberOfItems++;
        }

    }

    public Item removeFirst() {
        if (this.head == null) {
            throw new NoSuchElementException();
        }
        Item firstItem = this.head.t;
        this.head = this.head.next;
        if (this.head == null) {
            this.tail = null;
        }
        this.numberOfItems--;
        return firstItem;
    }

    public Item removeLast() {
        if (this.head == null) {
            throw new NoSuchElementException();
        }
        Item lastItem = this.tail.t;
        this.tail = this.tail.previous;
        if (this.tail == null) {
            this.head = null;
        }
        this.numberOfItems--;
        return lastItem;

    }


    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Node<Item> current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                Item t = current.t;
                current = current.next;
                return t;
            }
        };
    }

    private static class Node<T> {
        final T t;
        Node<T> previous;
        Node<T> next;

        private Node(T t) {
            this.t = t;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }
    }


//    public boolean isEmpty()                 // is the deque empty?
//    public void addFirst(Item item)          // add the item to the front
//    public void addLast(Item item)           // add the item to the end
//    public Item removeFirst()                // remove and return the item from the front
//    public Item removeLast()                 // remove and return the item from the end
//    public Iterator<Item> iterator()         // return an iterator over items in order from front to end
//    public static void main(String[] args)   // unit testing (optional)
}
