package com.rtemi.model;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Custom implementation of a HashSet.
 */
public class CustomHashSet<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private LinkedList<T>[] buckets;
    private int size = 0;

    public CustomHashSet() {
        buckets = new LinkedList[DEFAULT_CAPACITY];
    }

    /**
     * Adds an element to the set.
     * @param element The element to add.
     */
    public void put(T element) {
        if (contains(element)) {
            return;
        }
        if (size + 1 > LOAD_FACTOR * buckets.length) {
            resize();
        }
        int index = getIndex(element);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        buckets[index].add(element);
        size++;
    }

    /**
     * Checks if the set contains the specified element.
     * @param element The element to check.
     * @return True if the set contains the element, false otherwise.
     */
    public boolean contains(T element) {
        int index = getIndex(element);
        LinkedList<T> bucket = buckets[index];
        return bucket != null && bucket.contains(element);
    }

    /**
     * Removes an element from the set.
     * @param element The element to remove.
     * @return True if the element was removed, false otherwise.
     */
    public boolean remove(T element) {
        int index = getIndex(element);
        LinkedList<T> bucket = buckets[index];
        if (bucket != null && bucket.remove(element)) {
            size--;
            return true;
        }
        return false;
    }

    /**
     * Returns the size of the set.
     * @return The size of the set.
     */
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over the elements in the set.
     * @return An iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int bucketIndex = 0;
            private Iterator<T> bucketIterator = buckets[bucketIndex] == null ? null : buckets[bucketIndex].iterator();

            @Override
            public boolean hasNext() {
                while ((bucketIterator == null || !bucketIterator.hasNext()) && bucketIndex < buckets.length - 1) {
                    bucketIndex++;
                    bucketIterator = buckets[bucketIndex] == null ? null : buckets[bucketIndex].iterator();
                }
                return bucketIterator != null && bucketIterator.hasNext();
            }

            @Override
            public T next() {
                return bucketIterator.next();
            }
        };
    }

    /**
     * Gets the index of the bucket for the specified element.
     * @param element The element.
     * @return The index of the bucket.
     */
    private int getIndex(T element) {
        return element == null ? 0 : Math.abs(element.hashCode() % buckets.length);
    }

    /**
     * Resizes the internal array to accommodate more elements.
     */
    private void resize() {
        LinkedList<T>[] oldBuckets = buckets;
        buckets = new LinkedList[oldBuckets.length * 2];
        size = 0;
        for (LinkedList<T> bucket : oldBuckets) {
            if (bucket != null) {
                for (T element : bucket) {
                    put(element);
                }
            }
        }
    }
}
