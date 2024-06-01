package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import org.hamcrest.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class ThingTest {
    @Test
    public void givenFileNameAsAbsolutePath_whenUsingClasspath_thenFileData() throws IOException {
        String expectedData = "Hello, world!";

        Class<Thing> clazz = Thing.class;
        InputStream inputStream = clazz.getResourceAsStream("/fileTest.txt");
        String data = Thing.readFromInputStream(inputStream);

        assertThat(data, containsString(expectedData));
    }
}