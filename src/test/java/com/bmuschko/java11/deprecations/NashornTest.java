package com.bmuschko.java11.deprecations;

import org.junit.jupiter.api.Test;

import javax.script.ScriptEngineManager;

public class NashornTest {
    @Test
    void rendersDeprecationWarning() {
        new ScriptEngineManager().getEngineByName("nashorn");
    }
}
