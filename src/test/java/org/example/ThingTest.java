package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

class ThingTest {
    @Test
    public void givenFileNameAsAbsolutePath_whenUsingClasspath_thenFileData() throws IOException {
//        String expectedData = "Hello, world!";
        List<String> expectedList = List.of("Hello, world!", "My Name is bob");

//        Class<Thing> clazz = Thing.class;
//        InputStream inputStream = clazz.getResourceAsStream("/fileTest.txt");
//        String data = Thing.readFromInputStream(inputStream);

        Path file = Paths.get("src/main/resources/fileTest.txt");
        List<String> data = Files.readAllLines(file, StandardCharsets.UTF_8);

//        assertThat(data, containsString(expectedData));
        assertThat(data.get(0), equalTo(expectedList.get(0)));
        assertThat(data.get(1), equalTo(expectedList.get(1)));
        assertThat(data, equalTo(expectedList));
    }
}