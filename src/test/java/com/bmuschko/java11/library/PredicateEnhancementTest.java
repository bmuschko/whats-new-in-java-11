package com.bmuschko.java11.library;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PredicateEnhancementTest {
    @Test
    void canUsePredicateNotAsFilter() {
        List<String> months = List.of("January", "February", "March");
        List<String> filteredMonths = months
                .stream()
                //.filter(((Predicate<String>) month -> month.startsWith("M")).negate())
                .filter(Predicate.not(month -> month.startsWith("M")))
                .collect(Collectors.toList());
        assertEquals(List.of("January", "February"), filteredMonths);
    }
}
