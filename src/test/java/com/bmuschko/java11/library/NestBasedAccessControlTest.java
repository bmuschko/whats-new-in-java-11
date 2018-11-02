package com.bmuschko.java11.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class NestBasedAccessControlTest {
    private final Outer.Inner inner = new Outer.Inner();

    @Test
    void canAccessPrivateFieldFromOuterClass() {
        assertEquals("outer", inner.getOuterViaRegularFieldAccess());
    }

    @Test
    void canAccessPrivateFieldFromOuterClassViaReflection() {
        assertEquals("outer", inner.getOuterViaReflection());
    }
}