package com.bmuschko.java11.library;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CollectionEnhancementTest {
    @Test
    void canTurnListIntoArray() {
        List<String> months = new ArrayList<>();
        months.add("January");
        months.add("February");
        months.add("March");
        assertArrayEquals(new String[] { "January", "February", "March" }, months.toArray(new String[months.size()]));
        assertArrayEquals(new String[] { "January", "February", "March" }, months.toArray(String[]::new));
    }
}
