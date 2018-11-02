package com.bmuschko.java11.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Unicode10Test {
    @Test
    void canUseColbertEmoji() {
        String unicodeCharacter = "\uD83E\uDD28";
        assertEquals("🤨", unicodeCharacter);
    }
}
