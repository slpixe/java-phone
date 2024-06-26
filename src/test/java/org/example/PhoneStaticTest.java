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
        List<String> lines = List.of(
                "#Valid phone numbers:",
                "123-456-789",
                "",
                "123-456-780"
        );

        //act
        List<String> linesWithoutComments = PhoneStatic.removeComments(lines);

        //assert
        Assertions.assertEquals(lines.size(), 4);
        Assertions.assertEquals(linesWithoutComments.size(), 3);
        Assertions.assertEquals(lines.get(0), "#Valid phone numbers:");
        Assertions.assertNotEquals(linesWithoutComments.get(0), "#Valid phone numbers:");
    }

    @Test
    void removeEmptyLines() {
        //arrange
        List<String> lines = List.of(
                "#Valid phone numbers:",
                "123-456-789",
                "",
                "123-456-780"
        );

        //act
        List<String> linesWithoutEmptyLines = PhoneStatic.removeEmptyLines(lines);

        //assert
        Assertions.assertEquals(4, lines.size());
        Assertions.assertEquals(3, linesWithoutEmptyLines.size());
        Assertions.assertEquals(lines.get(2), "");
        Assertions.assertEquals(linesWithoutEmptyLines.get(2), "123-456-780");
    }

    @Test
    void numberOfLines() {
        //arrange
        List<String> lines = List.of(
                "#Valid phone numbers:",
                "123-456-789",
                "",
                "123-456-780"
                );

        //act
        int numberOfLines = PhoneStatic.numberOfLines(lines);

        //assert
        Assertions.assertEquals(4, numberOfLines);
    }

    @Test
    void isNumberValid() {
        //arrange
        //act
        boolean validNumber = PhoneStatic.isNumberValid("123-456-7890");
        boolean invalidNumber = PhoneStatic.isNumberValid("123-456-789");

        //assert
        Assertions.assertTrue(validNumber);
        Assertions.assertFalse(invalidNumber);
    }

    @Test
    void numberOfValidNumbers() {
        //arrange
        List<String> lines = List.of(
                "#Valid phone numbers:",
                "123-456-7891", //valid number
                "",
                "123-456-7802", //valid number
                "123-456-780" //invalid number
        );

        //act
        int numberOfValidNumbers = PhoneStatic.numberOfValidNumbers(lines);

        //assert
        Assertions.assertEquals(2, numberOfValidNumbers);
    }

    @Test
    void numberOfInvalidNumbers() {
        //arrange
        List<String> lines = List.of(
                "#Valid phone numbers:", //NaN
                "123-456-7891", //valid number
                "", //NaN
                "123-456-7802", //valid number
                "123-456-780" //invalid number
        );

        //act
        int numberOfInvalidNumbers = PhoneStatic.numberOfInvalidNumbers(lines);

        //assert
        Assertions.assertEquals(3, numberOfInvalidNumbers);
    }

    @Test
    void listOfValidNumbers() {
        //arrange
        List<String> lines = List.of(
                "#Valid phone numbers:", //NaN
                "123-456-7891", //valid number
                "", //NaN
                "123-456-7802", //valid number
                "123-456-780" //invalid number
        );

        //act
        List<String> listOfValidNumbers = PhoneStatic.listOfValidNumbers(lines);

        //assert
        Assertions.assertEquals(2, listOfValidNumbers.size());
        Assertions.assertEquals("123-456-7891", listOfValidNumbers.get(0));
        Assertions.assertEquals("123-456-7802", listOfValidNumbers.get(1));
    }
}