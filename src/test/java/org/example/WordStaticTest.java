package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

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
        Assertions.assertEquals(37, numberOfLines);
    }

    @Test
    void numberOfWords() {
        //arrange
        List<String> sevenWords = List.of("Whiskerby and the Box of Beguiling Bastet");
        List<String> seventyTwoWords = List.of(
                "Whiskerby and the Box of Beguiling Bastet",
                "",
                "Once upon a time, in the bustling metropolis of Ankh-Morpork, nestled amidst the shadows of the Unseen University and the ever-so-slightly aromatic Ankh River, there resided a most extraordinary cat. His name was Whiskerby, and he was no ordinary feline. Whiskerby was an adventurous soul, which, in a city like Ankh-Morpork, meant he was either very brave, very foolish, or a little bit of both."
        );

        //act
        int numberOfSevenWords = WordStatic.numberOfWords(sevenWords);
        int numberOfSeventyTwoWords = WordStatic.numberOfWords(seventyTwoWords);

        //assert
        Assertions.assertEquals(7, numberOfSevenWords);
        Assertions.assertEquals(72, numberOfSeventyTwoWords);
//        assertThat(numberOfWords, org.hamcrest.Matchers.greaterThan(5));
//        Assertions.assertEquals(72, numberOfWords);
    }
}