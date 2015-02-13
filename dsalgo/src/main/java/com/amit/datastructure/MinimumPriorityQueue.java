package com.amit.datastructure;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MinimumPriorityQueue<Key> implements Iterable<Key>, PriorityQueue<Key> {

    private Key[] priorityQueue;
    private int size;
    private Comparator comparator;

    /**
     * Build a minimum priority queue, in which finding the
     * minimum key and deleting it are O(1).
     *
     * @param capacity
     */
    public MinimumPriorityQueue(int capacity) {
        priorityQueue = (Key[]) new Object[capacity + 1];
        size = 0;
    }

    /**
     * Build a minimum priority queue, in which finding the
     * minimum key and deleting it are O(1).
     */
    public MinimumPriorityQueue() {
        this(1);
    }

    /**
     * Build a minimum priority queue, in which finding the
     * minimum key and deleting it are O(1).
     *
     * @param capacity
     * @param comparator
     */
    public MinimumPriorityQueue(int capacity, Comparator comparator) {
        priorityQueue = (Key[]) new Object[capacity + 1];
        size = 0;
        this.comparator = comparator;
    }

    /* (non-Javadoc)
	 * @see com.amit.datastructure.PriorityQueue#isEmpty()
	 */
    @Override
	public boolean isEmpty() {
        return (size == 0);
    }

    /* (non-Javadoc)
	 * @see com.amit.datastructure.PriorityQueue#size()
	 */
    @Override
	public int size() {
        return size;
    }

    /* (non-Javadoc)
	 * @see com.amit.datastructure.PriorityQueue#insert(Key)
	 */
    @Override
	public void insert(Key key) {
        if (size >= priorityQueue.length - 1) resize(priorityQueue.length * 2);

        priorityQueue[++size] = key;

        swim(size);
    }

    /* (non-Javadoc)
	 * @see com.amit.datastructure.PriorityQueue#remove()
	 */
    @Override
	public Key remove() throws NoSuchElementException {

        if (isEmpty()) throw new NoSuchElementException("Empty priority queue.");

        swap(1, size);
        Key min = priorityQueue[size--];

        sink(1);

        priorityQueue[size + 1] = null;
        if (size > 0 && (size == (priorityQueue.length - 1) / 4)) resize(priorityQueue.length / 2);

        return min;
    }

    /* (non-Javadoc)
	 * @see com.amit.datastructure.PriorityQueue#min()
	 */
    @Override
	public Key peek() throws NoSuchElementException {

        if (isEmpty()) throw new NoSuchElementException("Empty priority queue.");
        return priorityQueue[1];
    }

    /**
     * Helper methods
     */

    private void swim(int child) {
        while (child > 1 && greater(child / 2, child)) {
            swap(child, child / 2);
            child = child / 2;
        }
    }

    private void sink(int parent) {
        while (2 * parent <= size) {
            int child = 2 * parent;
            if (child < size && greater(child, child + 1)) child++;
            if (!greater(parent, child)) break;
            swap(parent, child);
            parent = child;
        }
    }


    private void resize(int newSize) {
        Key[] newPriorityQueue = (Key[]) new Object[newSize];
        for (int i = 1; i <= size; i++) {
            newPriorityQueue[i] = priorityQueue[i];
        }
        priorityQueue = newPriorityQueue;
    }


    // Helper functions for keys

    private boolean greater(int rank1, int rank2) {
        if (comparator != null) {
            return comparator.compare(priorityQueue[rank1], priorityQueue[rank2]) > 0;
        } else {
            return ((Comparable<Key>) priorityQueue[rank1]).compareTo(priorityQueue[rank2]) > 0;
        }
    }

    private void swap(int rank1, int rank2) {
        Key key = priorityQueue[rank1];
        priorityQueue[rank1] = priorityQueue[rank2];
        priorityQueue[rank2] = key;
    }


    /* (non-Javadoc)
	 * @see com.amit.datastructure.PriorityQueue#iterator()
	 */
    @Override
	public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Key> {

        private PriorityQueue<Key> copy;

        public HeapIterator() {
            if (comparator == null) copy = new MinimumPriorityQueue(size);
            else copy = new MinimumPriorityQueue(size, comparator);

            for (int i = 1; i <= size; i++) {
                copy.insert(priorityQueue[i]);
            }

        }

        public boolean hasNext() {
            return !copy.isEmpty();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Key next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.remove();
        }

    }

    public static void main(String[] args) {
        PriorityQueue minPQ = new MinimumPriorityQueue();
        for (int i = 10; i > 0; i--) {
            minPQ.insert(i);
        }

        for (int i = 10; i > 0; i--) {
            System.out.println(minPQ.remove());
        }

        try {
            minPQ.remove();
        } catch (NoSuchElementException e) {
            System.out.println("Passed exception test.");
        }
    }

}
