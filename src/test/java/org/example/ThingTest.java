package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class ThingTest {
    @Test
    public void givenFileNameAsAbsolutePath_whenUsingClasspath_thenFileData() throws IOException {
        String expectedData = "Hello, world!";

//        Class<Thing> clazz = Thing.class;
//        InputStream inputStream = clazz.getResourceAsStream("/fileTest.txt");
//        String data = Thing.readFromInputStream(inputStream);

        Path file = Paths.get("src/main/resources/fileTest.txt");
        String data = Files.readAllLines(file, StandardCharsets.UTF_8).get(0);

        assertThat(data, containsString(expectedData));
    }
}