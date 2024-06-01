package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class ThingStaticTest {
    @Test
    public void readAllLinesFromMethod() {
        List<String> expectedList = List.of("Hello, world!", "My Name is bob");
        List<String> meow = ThingStatic.readAllLinesAndReturn();
        Assertions.assertIterableEquals(meow, expectedList);
    }
}