package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

/**
 * This class represents a static utility for handling phone numbers.
 * It provides methods for reading phone numbers from a file and storing them in a list.
 */
public class PhoneStatic {

    public static final String FILE_PATH = "src/main/resources/fileTest.txt";
    public static final Pattern REGEX_VALID_PHONE_NUMBER = Pattern.compile("(\\(\\d{3}\\)\\s{1}\\d{3}-{1}\\d{4})|(\\d{3}\\s{1}\\d{3}\\s{1}\\d{4})|(\\d{3}-{1}\\d{3}-\\d{4})");

    /**
     * Default constructor.
     */
    PhoneStatic(){}

    static public List<String> readAllLinesAndReturn() {
        return PhoneStatic.readAllLinesAndReturn(FILE_PATH);
    }

    /**
     * Reads all lines from the file "src/main/resources/fileTest.txt" and returns them as a List.
     * If an IOException occurs during the reading process, it will be caught and printed to the console.
     * If an IOException occurs, an empty List will be returned.
     *
     * @return A List of strings representing the lines from the file.
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

    static public List<String> removeComments(List<String> lines) {
        return lines.stream().filter(line ->!line.startsWith("#")).toList();
    }

    static public List<String> removeEmptyLines(List<String> lines) {
        return lines.stream().filter(line ->!line.isEmpty()).toList();
    }

    static public int numberOfLines(List<String> lines) {
        return lines.size();
    }

    static public boolean isNumberValid(String number) {
        return REGEX_VALID_PHONE_NUMBER.matcher(number).matches();
    }

    static public int numberOfValidNumbers(List<String> lines) {
        return (int) lines.stream().filter(PhoneStatic::isNumberValid).count();
    }
}
