package com.bmuschko.java11.library;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilesEnhancementTest {
    @Test
    void canReadString() throws URISyntaxException, IOException {
        URI txtFileUri = getClass().getClassLoader().getResource("helloworld.txt").toURI();
        String content = Files.readString(Path.of(txtFileUri), Charset.defaultCharset());
        assertEquals("Hello World!", content);
    }

    @Test
    void canWriteString() throws IOException {
        Path tmpFilePath = Path.of(File.createTempFile("tempFile", ".tmp").toURI());
        Path returnedFilePath = Files.writeString(tmpFilePath, "Hello World!", Charset.defaultCharset(), StandardOpenOption.WRITE);
        assertEquals(tmpFilePath, returnedFilePath);
    }
}
