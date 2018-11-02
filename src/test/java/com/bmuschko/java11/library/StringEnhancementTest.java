package com.bmuschko.java11.library;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringEnhancementTest {
    @Test
    void canRepeatString() {
        assertEquals("CPU Usage:                  5%", renderInfo("CPU Usage:", "5%"));
        assertEquals("Memory Usage:          9.14 MB", renderInfo("Memory Usage:", "9.14 MB"));
        assertEquals("Free Disk:             96.5 GB", renderInfo("Free Disk:", "96.5 GB"));
    }

    private String renderInfo(String title, String value) {
        return title + " ".repeat(30 - title.length() - value.length()) + value;
    }

    @Test
    void canCheckIfStringContainsWhitespaces() {
        String nameFormFieldWithoutWhitespace = "Duke";
        String nameFormFieldWithWhitespace = " ";
        assertFalse(nameFormFieldWithoutWhitespace.isBlank());
        assertTrue(nameFormFieldWithWhitespace.isBlank());
    }

    @Test
    void canStripStringOfLeadingAndTrailingWhitespaces() {
        String fooString = "      foo     ";
        assertEquals("foo", fooString.strip());
        assertEquals("foo     ", fooString.stripLeading());
        assertEquals("      foo", fooString.stripTrailing());
    }

    @Test
    void canStreamLines() {
        String testString = "This\nis\na\ntest";
        List<String> lines = new ArrayList<>();
        testString.lines().forEach(line -> lines.add(line));
        assertEquals(List.of("This", "is", "a", "test"), lines);
    }
}
