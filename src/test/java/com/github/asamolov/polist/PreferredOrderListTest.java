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
}