package com.bmuschko.java11.launch;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingleFileSourceCodeLaunchTest {
    @Test
    void canLaunchWithoutCompilation() throws URISyntaxException, IOException, InterruptedException {
        File javaSourceFile = new File(getClass().getClassLoader().getResource("HelloWorld.java").toURI());
        ProcessBuilder processBuilder = new ProcessBuilder("java", "--source 11", javaSourceFile.getAbsolutePath());
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        String result = new BufferedReader(new InputStreamReader(process.getInputStream()))
                .lines().collect(Collectors.joining(System.getProperty("line.separator")));
        int execCode = process.waitFor();
        assertEquals(0, execCode, result);
        assertEquals("Hello World!", result);
    }
}
