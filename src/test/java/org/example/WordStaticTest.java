package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WordStaticTest {

    @Test
    void readAllLinesAndReturn() {
        //arrange
        //act
        List<String> lines = WordStatic.readAllLinesAndReturn();

        //assert
        assertThat(lines.size(), org.hamcrest.Matchers.greaterThan(5));
        assertThat(lines.get(0), org.hamcrest.Matchers.equalTo("Whiskerby and the Box of Beguiling Bastet"));
    }

    @Test
    void testReadAllLinesAndReturn() {
        //arrange
        //act
        List<String> lines = WordStatic.readAllLinesAndReturn("src/main/resources/peachStory.txt");

        //assert
        assertThat(lines.size(), org.hamcrest.Matchers.greaterThan(5));
        assertThat(lines.get(0), org.hamcrest.Matchers.equalTo("Whiskerby and the Box of Beguiling Bastet"));
    }

    @Test
    void numberOfLines() {
        //arrange
        List<String> lines = WordStatic.readAllLinesAndReturn("src/main/resources/peachStory.txt");
        System.out.println(lines);

        //act
        int numberOfLines = WordStatic.numberOfLines(lines);

        //assert
        assertThat(numberOfLines, org.hamcrest.Matchers.greaterThan(5));
        assertEquals(37, numberOfLines);
    }

    @Test
    void numberOfWordsWPlus() {
        //arrange
        List<String> sevenWords = List.of("Whiskerby and the Box of Beguiling Bastet");
        List<String> seventyTwoWords = List.of(
                "Whiskerby and the Box of Beguiling Bastet",
                "",
                "Once upon a time, in the bustling metropolis of Ankh-Morpork, nestled amidst the shadows of the Unseen University and the ever-so-slightly aromatic Ankh River, there resided a most extraordinary cat. His name was Whiskerby, and he was no ordinary feline. Whiskerby was an adventurous soul, which, in a city like Ankh-Morpork, meant he was either very brave, very foolish, or a little bit of both."
        );
        List<String> twoWords = List.of("Whiskerby’s curiosity");

        //act
        int numberOfSevenWords = WordStatic.numberOfWordsWPlus(sevenWords);
        int numberOfSeventyTwoWords = WordStatic.numberOfWordsWPlus(seventyTwoWords);
        int numberOfTwoWords = WordStatic.numberOfWordsWPlus(twoWords);

        //assert
        assertEquals(7, numberOfSevenWords);
        Assertions.assertEquals(72, numberOfSeventyTwoWords);
        Assertions.assertEquals(2, numberOfTwoWords);
//        assertThat(numberOfWords, org.hamcrest.Matchers.greaterThan(5));
//        Assertions.assertEquals(72, numberOfWords);
    }

    @Test
    void runTest() {
        int matches1 = WordStatic.runTest("foo", "foofoo");
        assertEquals(2, matches1);;

        int matches2 = WordStatic.runTest("\\w+", "Whiskerby and the Box of Beguiling Bastet");
        assertEquals(7, matches2);
    }
}