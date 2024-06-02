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

public class WordStatic {

    public static final String FILE_PATH = "src/main/resources/peachStory.txt";

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
        final Pattern MATCH_ALL_WORDS_PATTERN = Pattern.compile("([\\w-’']+)");

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

//    public static Map<String, Long> wordFrequencies(List<String> lines) {
//        Map<String, Long> thing1 = lines
//                .stream()
//                .collect(
//                        Collectors.groupingBy(
//                                String::toLowerCase,
//                                Collectors.counting()
//                        )
//                );
//
//        System.out.println(thing1);
//
//        return thing1;
//    }

    public static Map<String, Long> wordFrequencies(List<String> lines) {
        Map<String, Long> wordCounts = new HashMap<>();

        for (String line : lines) {
            String[] words = line.toLowerCase().split("\\s+");
            for (String word : words) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0L) + 1);
            }
        }

        System.out.println(wordCounts); // Print the word frequencies (optional)

        return wordCounts;
    }
}
