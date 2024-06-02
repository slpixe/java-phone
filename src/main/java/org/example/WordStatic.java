package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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

    static public int numberOfWords(List<String> lines) {
        //return lines.stream().map(String::split).flatMap(List::stream).distinct().count();
        return lines
                .stream()
                .flatMap(
                        line -> Stream.of(line.split("\\s+"))
                )
                .distinct()
                .collect(
                        Collectors.toList()
                )
                .size();
    }

//    static public List<String> removeComments(List<String> lines) {
//        return lines.stream().filter(line -> !line.startsWith("#")).toList();
//    }
//
//    static public List<String> removeEmptyLines(@org.jetbrains.annotations.NotNull List<String> lines) {
//        return lines.stream().filter(line -> !line.isEmpty()).toList();
//    }
//
//    static public int numberOfLines(List<String> lines) {
//        return lines.size();
//    }
//
//    static public boolean isNumberValid(String number) {
//        return REGEX_VALID_PHONE_NUMBER.matcher(number).matches();
//    }
//
//    static public int numberOfValidNumbers(List<String> lines) {
//        return (int) lines.stream().filter(WordStatic::isNumberValid).count();
//    }
//
//    static public int numberOfInvalidNumbers(List<String> lines) {
//        return (int) lines.stream().filter(line -> !isNumberValid(line)).count();
//    }
//
//    static public List<String> listOfValidNumbers(List<String> lines) {
//        return lines.stream().filter(WordStatic::isNumberValid).toList();
//    }
}
