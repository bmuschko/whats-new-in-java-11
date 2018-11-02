package com.bmuschko.java11.library;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OptionalEnhancementTest {
    @Test
    void canCheckOptionalForEmpty() {
        String payDay = null;
        assertTrue(!Optional.ofNullable(payDay).isPresent());
        assertTrue(Optional.ofNullable(payDay).isEmpty());
        payDay = "Monday";
        assertFalse(!Optional.ofNullable(payDay).isPresent());
        assertFalse(Optional.ofNullable(payDay).isEmpty());
    }
}
