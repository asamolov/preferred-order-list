package com.github.asamolov.polist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PreferredOrderListTest {

    @Test
    void shouldInsertItemsWithOrder() {
        var list = new PreferredOrderList<String>();
        list.insert("A", 0);
        assertEquals("A", list.get(0));
    }
}