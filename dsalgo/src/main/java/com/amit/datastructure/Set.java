package com.amit.datastructure;

public interface Set<T> {
	/**
	 * Add value to set.
	 *
	 * @param value to add.
	 * @return True if added.
	 */
	public boolean add(T value);
	/**
	 * Remove value from set.
	 *
	 * @param value to remove.
	 * @return True if removed.
	 */
	public boolean remove(T value);
	/**
	 * Clear the entire set.
	 */
	public void clear();
	/**
	 * Does the set contain value.
	 *
	 * @param value to search set for.
	 * @return True if set contains value.
	 */
	public boolean contains(T value);
	/**
	 * Size of the set.
	 *
	 * @return size of the set.
	 */
	public int size();
	/**
	 * Validate the set according to the invariants.
	 *
	 * @return True if the set is valid.
	 */
	public boolean validate();
	/**
	 * Get this Set as a Java compatible Set
	 *
	 * @return Java compatible Set
	 */
	public java.util.Set<T> toSet();
	/**
	 * Get this Set as a Java compatible Collection
	 *
	 * @return Java compatible Collection
	 */
	public java.util.Collection<T> toCollection();
}