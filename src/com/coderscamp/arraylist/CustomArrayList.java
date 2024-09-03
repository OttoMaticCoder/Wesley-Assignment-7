package com.coderscamp.arraylist;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
	private int size = 0;

	@Override
	public boolean add(T item) {
		if (size >= items.length) {
				items = Arrays.copyOf(items, items.length * 2);

		}
		items[size++] = item;

		return true;
	}

	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {
		if(size > items.length || size < 0) {
			throw new IndexOutOfBoundsException("Index " + index + "is out of bounds for index size 0-" + size);
		}
		if(size == items.length) {
			resizeArray();
		}
		for (int i = size; i > index; i--) {
			items[i] = items[i-1];
		}
		items[index] = item;
		size++;
		return true;
		
	}

	private void resizeArray() {
		items = Arrays.copyOf(items, items.length * 2);
		
	}

	@Override
	public int getSize() {

		return size;
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		

		return (T) items[index];
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index: " + index + " Size: " + size);
		}
		
		T removedItem = (T) items[index];
		for (int i = index; i < size - 1; i++) {
			items[i] = items[i + 1];
		}
		items[size - 1] = null;
		size--;
		return removedItem;
		
	}

}