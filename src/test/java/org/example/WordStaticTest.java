package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    void testSevenWords() {
        List<String> sevenWords = List.of("Whiskerby and the Box of Beguiling Bastet");
        int numberOfSevenWords = WordStatic.numberOfWords(sevenWords);
        assertEquals(7, numberOfSevenWords, "Expected 7 words");
    }

    @Test
    void testSeventyTwoWords() {
        List<String> seventyTwoWords = List.of(
                "Whiskerby and the Box of Beguiling Bastet",
                "",
                "Once upon a time, in the bustling metropolis of Ankh-Morpork, nestled amidst the shadows of the Unseen University and the ever-so-slightly aromatic Ankh River, there resided a most extraordinary cat. His name was Whiskerby, and he was no ordinary feline. Whiskerby was an adventurous soul, which, in a city like Ankh-Morpork, meant he was either very brave, very foolish, or a little bit of both."
        );
        int numberOfSeventyTwoWords = WordStatic.numberOfWords(seventyTwoWords);
        assertEquals(72, numberOfSeventyTwoWords, "Expected 72 words");
    }

    @Test
    void testTwoWords() {
        List<String> twoWords = List.of("Whiskerby’s curiosity");
        int numberOfTwoWords = WordStatic.numberOfWords(twoWords);
        assertEquals(2, numberOfTwoWords, "Expected 2 words");
    }

    @Test
    void testStoryWords() {
        List<String> story = WordStatic.readAllLinesAndReturn();
        int numberOfStoryWords = WordStatic.numberOfWords(story);
        assertEquals(952, numberOfStoryWords, "Expected 952 words");
    }

    @Test
    void testNumberOfWordsWithTricks() {
        //arrange
        List<String> trickyWords = List.of(
                "Whiskerby’s curiosity",
                "(where the floor)",
                "his life's mission",
                "ever-so-slightly"
        );

        //act
        int numberOfA1Words = WordStatic.numberOfWords(trickyWords.get(0).lines().toList());
        int numberOfA2Words = WordStatic.numberOfWords(trickyWords.get(1).lines().toList());
        int numberOfA3Words = WordStatic.numberOfWords(trickyWords.get(2).lines().toList());
        int numberOfA4Words = WordStatic.numberOfWords(trickyWords.get(3).lines().toList());

        //assert
        assertEquals(2, numberOfA1Words, "Expected 2 words");
        assertEquals(3, numberOfA2Words, "Expected 3 words");
        assertEquals(3, numberOfA3Words, "Expected 3 words");
        assertEquals(1, numberOfA4Words, "Expected 1 words");
    }


    @Test
    void runTest() {
        int matches1 = WordStatic.runTest("foo", "foofoo");
        assertEquals(2, matches1);;

        int matches2 = WordStatic.runTest("\\w+", "Whiskerby and the Box of Beguiling Bastet");
        assertEquals(7, matches2);
    }

    @Test
    void wordFrequencies() {
        //arrange
        List<String> bob = List.of(
                "Whiskerby pie happy eat pie",
                "",
                "Once happy",
                "Whiskerby’s curiosity",
                "(where the life's Whiskerby’s floor)",
                "where his ever-so-slightly life's mission",
                "ever-so-slightly"
        );

        //act
        Map<String, Long> wordFrequencies = WordStatic.wordFrequencies(bob);
//        System.out.println(wordFrequencies);

        //assert
        Assertions.assertEquals(1L, wordFrequencies.get("whiskerby"));
        Assertions.assertEquals(2L, wordFrequencies.get("pie"));
        Assertions.assertEquals(2L, wordFrequencies.get("happy"));
        Assertions.assertEquals(2L, wordFrequencies.get("whiskerby’s"));
        Assertions.assertEquals(2L, wordFrequencies.get("ever-so-slightly"));
        Assertions.assertEquals(2L, wordFrequencies.get("life's"));
        Assertions.assertEquals(2L, wordFrequencies.get("where"));
    }

    @Test
    void testSortedWordFrequencies() {
        //arrange
        List<String> bob = List.of(
                "Whiskerby pie happy pie",
                "",
                "pie happy",
                "Whiskerby’s pie curiosity",
                "(pie life's Whiskerby’s)",
                "life's",
                "ever-so-slightly pie"
        );

        Map<String, Long> expected = new HashMap<String, Long>();
        expected.put("pie", 6L);
        expected.put("whiskerby’s", 2L);
        expected.put("happy", 2L);
        expected.put("life's", 2L);
        expected.put("ever-so-slightly", 1L);
        expected.put("curiosity", 1L);
        expected.put("whiskerby", 1L);
        Map<String, Long> sortedExpected = WordStatic.sortByValue(expected);

        //act
        Map<String, Long> wordFrequencies = WordStatic.wordFrequencies(bob);
        Map<String, Long> sortedWordFrequencies = WordStatic.sortByValue(wordFrequencies);
        System.out.println("res" + sortedWordFrequencies);
        System.out.println("exp" + sortedExpected);

        //assert
//        Assertions.assertEquals(1L, sortedWordFrequencies.get("whiskerby"));
//        Assertions.assertEquals(6L, sortedWordFrequencies.get("pie"));
        Assertions.assertEquals(sortedExpected, sortedWordFrequencies);
    }
}