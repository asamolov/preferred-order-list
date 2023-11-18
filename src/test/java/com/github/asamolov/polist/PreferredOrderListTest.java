package com.github.asamolov.polist;

import com.github.asamolov.polist.PreferredOrderList.ItemWithOrder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PreferredOrderListTest {

    @Test
    void shouldInsertItemsWithoutOrder() {
        var list = new PreferredOrderList<String>();
        list.insert("A");
        assertEquals("A", list.get(0));
        assertEquals(new ItemWithOrder<>("A", null), list.getWithOrder(0));
    }

    @Test
    void shouldInsertItemsWithOrder() {
        var list = new PreferredOrderList<String>();
        list.insert("A");
        list.insert("B", 1);
        assertEquals("A", list.get(0));
        assertEquals(new ItemWithOrder<>("A", null), list.getWithOrder(0));
        assertEquals("B", list.get(1));
        assertEquals(new ItemWithOrder<>("B", 1), list.getWithOrder(1));
    }

    @Test
    void shouldInsertItemsWithOrderOutOfBounds() {
        var list = new PreferredOrderList<String>();
        list.insert("A", 1);
        assertEquals("A", list.get(0));
        assertEquals(new ItemWithOrder<>("A", 1), list.getWithOrder(0));
    }
}