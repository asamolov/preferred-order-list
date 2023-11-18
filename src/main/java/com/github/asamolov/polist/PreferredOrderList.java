package com.github.asamolov.polist;

public class PreferredOrderList<T> {

    /**
     * Insert without order. Item will be inserted in the best matching position (or at the end by default).
     * @param item item to insert
     */
    public void insert(T item) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    /**
     * Insert specifying a desired order. The list will try to put the item in the requested order, and this might
     * move other items. If two items has the same order, the new item will follow the existing item.
     * @param item item to insert
     * @param order desired order
     */
    public void insert(T item, int order) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    /**
     * Returns an item from the list
     * @param index index of the item in the list
     * @return an item
     */
    public T get (int index) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    /**
     * Changes the order of the first matching item.
     * @param item item to change an order
     * @param newOrder new order
     */
    public void setOrder(T item, int newOrder) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    /**
     * Temporarely hides an item from the list
     * @param item item to hide
     */
    public void hide(T item) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    /**
     * Returns previously hidden item.
     * @param item item to unhide
     */
    public void unhide(T item) {
        throw new UnsupportedOperationException("not implemented yet");
    }
}
