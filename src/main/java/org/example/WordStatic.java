package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

public class WordStatic {

    public static final String FILE_PATH = "src/main/resources/peachStory.txt";

    public static final Pattern MATCH_ALL_WORDS_PATTERN = Pattern.compile("([\\w-’']+)");

    /**
     * Default constructor.
     */
    WordStatic() {}

    static public List<String> readAllLinesAndReturn() {
        return WordStatic.readAllLinesAndReturn(FILE_PATH);
    }

    static public List<String> readAllLinesAndReturn(String filePath) {
        try {
            Path file = Paths.get(filePath);
            return Files.readAllLines(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    static public int numberOfLines(List<String> lines) {
        return lines.size();
    }

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

    public static int runTest(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int matches = 0;
        while (matcher.find()) {
            matches++;
        }
        return matches;
    }

    public static Map<String, Long> wordFrequencies(List<String> lines) {
        return lines.stream()
                .flatMap(line -> MATCH_ALL_WORDS_PATTERN.matcher(line).results())
                .map(matchResult -> matchResult.group().toLowerCase())
                .collect(Collectors.groupingBy(
                        word -> word,
                        Collectors.counting()
                ));
    }

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
