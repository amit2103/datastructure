package com.amit.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface PriorityQueue<Key> {

	/**
	 * Returns true if the priority queue is empty and
	 * false otherwise.
	 */
	public abstract boolean isEmpty();

	/**
	 * Returns the size of the priority queue.
	 */
	public abstract int size();

	/**
	 * Inserts the given key in the priority queue.
	 *
	 * @param key
	 */
	public abstract void insert(Key key);

	/**
	 * Deletes the minimum key and returns it.
	 */
	public abstract Key remove() throws NoSuchElementException;

	/**
	 * Returns the minimum key
	 */
	public abstract Key peek() throws NoSuchElementException;

	/**
	 * Returns an iterator over the keys in the priority queue,
	 * in increasing order.
	 *
	 * @return
	 */
	public abstract Iterator<Key> iterator();

}