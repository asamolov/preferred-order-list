package com.github.asamolov.polist;

import com.github.asamolov.polist.PreferredOrderList.ItemWithOrder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PreferredOrderListTest {

    @Test
    void shouldInsertItemsWithoutOrder() {
        var list = new PreferredOrderList<String>();
        list.insert("A");
        assertEquals("[ (A -) ]", list.toString());
    }

    @Test
    void shouldInsertItemsWithOrder() {
        var list = new PreferredOrderList<String>();
        list.insert("A");
        list.insert("B", 1);
        assertEquals("[ (A -) (B 1) ]", list.toString());
    }

    @Test
    void shouldInsertItemsWithOrderOutOfBounds() {
        var list = new PreferredOrderList<String>();
        list.insert("A", 1);
        assertEquals("[ (A 1) ]", list.toString());
    }

    @Test
    void shouldMoveItemsWithoutOrder() {
        var list = new PreferredOrderList<String>();
        list.insert("A");
        list.insert("B", 1);
        list.insert("C", 0);
        assertEquals("[ (C 0) (B 1) (A -) ]", list.toString());
    }
}