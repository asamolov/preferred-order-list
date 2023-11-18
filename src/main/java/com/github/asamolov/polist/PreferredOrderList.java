package com.github.asamolov.polist;

import java.util.*;
import java.util.stream.Collectors;

public class PreferredOrderList<T> {

    private final List<ItemWithOrder<T>> list = new ArrayList<>();

    /**
     * Insert without order. Item will be inserted in the best matching position (or at the end by default).
     *
     * @param item item to insert, non-null
     */
    public void insert(T item) {
        Objects.requireNonNull(item, "Item should not be null");
        insertInternal(new ItemWithOrder<T>(item, null));
    }

    /**
     * Insert specifying a desired order. The list will try to put the item in the requested order, and this might
     * move other items. If two items has the same order, the new item will follow the existing item.
     *
     * @param item  item to insert, non-null
     * @param order desired order
     */
    public void insert(T item, int order) {
        Objects.requireNonNull(item, "Item should not be null");
        insertInternal(new ItemWithOrder<T>(item, order));
    }

    // rebalancing the list
    private void insertInternal(ItemWithOrder<T> newItem) {
        var index = 0;
        while (index < list.size()) {
            var currentItem = list.get(index);
            // I think it's possible to simplify this expression (can we use nvls?), but too late for this now
            if (newItem.order == null) {
                if (currentItem.order != null && currentItem.order > index) { // currentItem.order > index, newItem = no order
                    // set new item instead of current one and move forward
                    list.set(index, newItem);
                    newItem = currentItem;
                }
            } else if (newItem.order > index) { // newItem.order < index
                if (currentItem.order != null && currentItem.order > newItem.order) { // new item has smaller order than the current item
                    // set new item instead of current one and move forward
                    list.set(index, newItem);
                    newItem = currentItem;
                }
            } else if (newItem.order <= index) {
                if (currentItem.order == null || currentItem.order > newItem.order) {
                    // set new item instead of current one and move forward
                    list.set(index, newItem);
                    newItem = currentItem;
                }
            }
            index++;
        }
        list.add(newItem);
    }

    /**
     * Returns an item from the list
     *
     * @param index index of the item in the list
     * @return an item
     */
    public T get(int index) {
        Objects.checkIndex(index, list.size());
        return list.get(index).item;
    }

    /**
     * Returns an item with order from the list
     *
     * @param index index of the item in the list
     * @return an item with order
     */
    public ItemWithOrder<T> getWithOrder(int index) {
        Objects.checkIndex(index, list.size());
        return list.get(index);
    }

    /**
     * @return size of the list
     */
    public int size() {
        return list.size();
    }

    /**
     * Changes the order of the first matching item.
     *
     * @param item     item to change an order
     * @param newOrder new order
     */
    public void setOrder(T item, int newOrder) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    /**
     * Temporarely hides an item from the list
     *
     * @param item item to hide
     */
    public void hide(T item) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    /**
     * Returns previously hidden item.
     *
     * @param item item to unhide
     */
    public void unhide(T item) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    public record ItemWithOrder<T>(T item, Integer order) {
        @Override
        public String toString() {
            return "(" + item + " " + Optional.ofNullable(order).map(Object::toString).orElse("-") + ")";
        }
    }

    @Override
    public String toString() {
        return list.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" ", "[ ", " ]"));
    }
}
