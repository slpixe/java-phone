package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * A utility class for performing various text analysis operations, such as counting lines, words, and word frequencies.
 * This class provides static methods for reading text files, calculating line and word counts, and calculating word frequencies.
 * It also includes a method for sorting word frequencies by value in descending order.
 *
 * <p>The class uses a regular expression pattern to match words in a given text.
 * The pattern matches one or more word characters, hyphens, or apostrophes.
 * Word characters include uppercase and lowercase letters, digits, and underscores.
 *
 * <p>The class also provides a method for running a test with a regular expression and a given text.
 * This method counts the number of matches of the regular expression in the text.
 *
 * <p>The default file path for the Peach Story text file is specified in the {@link #FILE_PATH} constant.
 * This constant can be used when reading or writing data from/to the file.
 *
 * <p>The class is thread-safe and can be used in a multi-threaded environment.
 */
public class WordStatic {

    /**
     * The file path for the Peach Story text file.
     * This constant specifies the location of the "peachStory.txt" file within the project's resources directory.
     * Use this path when reading or writing data from/to the file.
     */
    public static final String FILE_PATH = "src/main/resources/peachStory.txt";

    /**
     * A regular expression pattern that matches all words in a given text.
     * <p>
     * The pattern matches one or more word characters, hyphens, or apostrophes.
     * Word characters include uppercase and lowercase letters, digits, and underscores.
     * <p>
     * This pattern is used to extract words from a text for further analysis,
     * such as counting the number of words or calculating word frequencies.
     */
    public static final Pattern MATCH_ALL_WORDS_PATTERN = Pattern.compile("([\\w-’']+)");

    /**
     * Default constructor.
     */
    WordStatic() {}


    /**
     * Reads all lines from the default file and returns them as a list of strings.
     * This is a convenience method that calls the readAllLinesAndReturn(String filePath) method
     * with the default file path defined in the FILE_PATH constant.
     *
     * @return A list of strings, where each string is a line from the default file.
     * If an error occurs while reading the file, an empty list is returned.
     */
    static public List<String> readAllLinesAndReturn() {
        return WordStatic.readAllLinesAndReturn(FILE_PATH);
    }

    /**
     * Reads all lines from a file and returns them as a list of strings.
     *
     * @param filePath The path to the file to be read.
     * @return A list of strings, where each string is a line from the file.
     * If an error occurs while reading the file, an empty list is returned.
     */
    static public List<String> readAllLinesAndReturn(String filePath) {
        try {
            Path file = Paths.get(filePath);
            return Files.readAllLines(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    /**
     * Calculates the number of lines in a list of strings.
     *
     * @param lines A list of strings, where each string represents a line.
     * @return The number of lines in the list.
     */
    static public int numberOfLines(List<String> lines) {
        return lines.size();
    }

    /**
     * Calculates the number of words in a list of strings.
     *
     * @param lines A list of strings, where each string represents a line.
     * @return The total number of words in all lines.
     */
    static public int numberOfWords(List<String> lines) {
        return lines
                .stream()
                .mapToInt(
                        line -> (int) MATCH_ALL_WORDS_PATTERN
                                .matcher(line)
                                .results()
                                .count()
                )
                .sum();
    }

    /**
     * Counts the number of matches of a regular expression in a given text.
     *
     * @param regex The regular expression to be matched.
     * @param text  The text in which to search for matches.
     * @return The number of matches found in the text.
     */
    public static int runTest(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int matches = 0;
        while (matcher.find()) {
            matches++;
        }
        return matches;
    }

    /**
     * Calculates the frequency of each word in a list of strings.
     *
     * @param lines A list of strings, where each string represents a line.
     * @return A map where the keys are the words and the values are their frequencies.
     */
    public static Map<String, Long> wordFrequencies(List<String> lines) {
        return lines.stream()
                .flatMap(line -> MATCH_ALL_WORDS_PATTERN.matcher(line).results())
                .map(matchResult -> matchResult.group().toLowerCase())
                .collect(Collectors.groupingBy(
                        word -> word,
                        Collectors.counting()
                ));
    }

    /**
     * Sorts a map of word frequencies by value in descending order.
     *
     * @param wordFrequencies A map where the keys are the words and the values are their frequencies.
     * @return A new map with the same entries as the input map, but sorted by value in descending order.
     */
    public static Map<String, Long> sortByValue(Map<String, Long> wordFrequencies) {
        return wordFrequencies
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}
