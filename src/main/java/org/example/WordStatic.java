package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordStatic {

    public static final String FILE_PATH = "src/main/resources/peachStory.txt";

    //public static final Pattern REGEX_VALID_PHONE_NUMBER = Pattern.compile("(\\(\\d{3}\\)\\s{1}\\d{3}-{1}\\d{4})|(\\d{3}\\s{1}\\d{3}\\s{1}\\d{4})|(\\d{3}-{1}\\d{3}-\\d{4})");

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

    static public int numberOfWordsWPlus(List<String> lines) {
        final Pattern MATCH_ALL_WORDS_INCLUDING_HYPHENATED = Pattern.compile("([\\w-’']+)");
        //int numberOfWordsOverAllLines = 0;

//        for (String line : lines) {
//            Matcher matcher = MATCH_ALL_WORDS_INCLUDING_HYPHENATED.matcher(line);
//            while (matcher.find()) {
//                numberOfWordsOverAllLines++;
//            }
//        }

//        System.out.println("Total number of words across all lines: " + numberOfWordsOverAllLines);
//        return numberOfWordsOverAllLines;

        return lines
                .stream()
                .mapToInt(
                        line -> (int) MATCH_ALL_WORDS_INCLUDING_HYPHENATED
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
}
