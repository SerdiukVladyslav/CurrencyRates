package com.example.currencyrates;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class FilterHelperTest {

    @Test
    public void testFilter() {
        ArrayList<String> list = new ArrayList<>();
        list.add("USD - 1.0");
        list.add("EUR - 0.9");
        list.add("JPY - 150");

        ArrayList<String> result = FilterHelper.filter(list, "us");
        assertEquals(1, result.size());
        assertEquals("USD - 1.0", result.get(0));

        result = FilterHelper.filter(list, "J");
        assertEquals(1, result.size());
        assertEquals("JPY - 150", result.get(0));

        result = FilterHelper.filter(list, "");
        assertEquals(3, result.size());
    }
}
