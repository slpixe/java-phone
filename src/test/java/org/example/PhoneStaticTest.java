package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

class PhoneStaticTest {
    @Test
    public void readAllLinesFromMethod() {
        List<String> expectedList = List.of("Hello, world!", "My Name is bob");
        List<String> meow = PhoneStatic.readAllLinesAndReturn();
        Assertions.assertIterableEquals(meow, expectedList);
    }
}