package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

class PhoneStaticTest {

    @Test
    void readAllLinesAndReturn() {
        //arrange
        //act
        List<String> lines = PhoneStatic.readAllLinesAndReturn();

        //assert
        assertThat(lines.size(), org.hamcrest.Matchers.greaterThan(5));
        assertThat(lines.get(0), org.hamcrest.Matchers.equalTo("#Valid phone numbers:"));
    }

    @Test
    void readAllLinesAndReturnWithArg() {
        //arrange
        final String FILE_PATH = "src/main/resources/fileTest.txt";

        //act
        List<String> lines = PhoneStatic.readAllLinesAndReturn(FILE_PATH);

        //assert
        assertThat(lines.size(), org.hamcrest.Matchers.greaterThan(5));
        assertThat(lines.get(0), org.hamcrest.Matchers.equalTo("#Valid phone numbers:"));
    }

    @Test
    void removeComments() {
        //arrange
        List<String> lines = PhoneStatic.readAllLinesAndReturn();

        //act
        List<String> linesWithoutComments = PhoneStatic.removeComments(lines);

        //assert
        Assertions.assertTrue(linesWithoutComments.size() > 5);
        Assertions.assertFalse(linesWithoutComments.get(0).startsWith("#"));
    }

    @Test
    void removeEmptyLines() {
        //arrange
        List<String> lines = PhoneStatic.readAllLinesAndReturn();

        //act
        List<String> linesWithoutEmptyLines = PhoneStatic.removeEmptyLines(lines);

        //assert
        // lines starts at 12 rows, after running removeEmptyLines it goes to 11 rows, calling it multiple times keeps it at 11 rows
        Assertions.assertEquals(13, lines.size());
        Assertions.assertEquals(12, linesWithoutEmptyLines.size());
        Assertions.assertFalse(linesWithoutEmptyLines.get(0).isEmpty());
    }
}