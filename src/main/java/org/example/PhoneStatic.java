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

    /**
     * The file path for reading phone numbers.
     */
    public static final String FILE_PATH = "src/main/resources/fileTest.txt";

    /**
     * Regular expression pattern for valid phone numbers.
     */
    public static final Pattern REGEX_VALID_PHONE_NUMBER = Pattern.compile("(\\(\\d{3}\\)\\s{1}\\d{3}-{1}\\d{4})|(\\d{3}\\s{1}\\d{3}\\s{1}\\d{4})|(\\d{3}-{1}\\d{3}-\\d{4})");

    /**
     * Default constructor.
     */
    PhoneStatic() {}

    /**
     * Reads all lines from the file specified by {@link #FILE_PATH} and returns them as a List.
     * If an IOException occurs during the reading process, it will be caught and printed to the console.
     * If an IOException occurs, an empty List will be returned.
     *
     * @return A List of strings representing the lines from the file.
     */
    static public List<String> readAllLinesAndReturn() {
        return PhoneStatic.readAllLinesAndReturn(FILE_PATH);
    }

    /**
     * Reads all lines from the specified file path and returns them as a List.
     * If an IOException occurs during the reading process, it will be caught and printed to the console.
     * If an IOException occurs, an empty List will be returned.
     *
     * @param filePath The path to the file containing phone numbers.
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

    /**
     * Removes comments (lines starting with "#") from the given list of lines.
     *
     * @param lines The list of lines to process.
     * @return A filtered list without comments.
     */
    static public List<String> removeComments(List<String> lines) {
        return lines.stream().filter(line -> !line.startsWith("#")).toList();
    }

    /**
     * Removes empty lines from the given list of lines.
     *
     * @param lines The list of lines to process.
     * @return A filtered list without empty lines.
     */
    static public List<String> removeEmptyLines(List<String> lines) {
        return lines.stream().filter(line -> !line.isEmpty()).toList();
    }

    /**
     * Returns the number of lines in the given list.
     *
     * @param lines The list of lines.
     * @return The number of lines.
     */
    static public int numberOfLines(List<String> lines) {
        return lines.size();
    }

    /**
     * Checks if a phone number is valid based on the defined regular expression.
     *
     * @param number The phone number to validate.
     * @return true if the number is valid, false otherwise.
     */
    static public boolean isNumberValid(String number) {
        return REGEX_VALID_PHONE_NUMBER.matcher(number).matches();
    }

    /**
     * Returns the number of valid phone numbers in the given list.
     *
     * @param lines The list of phone numbers.
     * @return The count of valid phone numbers.
     */
    static public int numberOfValidNumbers(List<String> lines) {
        return (int) lines.stream().filter(PhoneStatic::isNumberValid).count();
    }

    /**
     * Returns the number of invalid phone numbers in the given list.
     *
     * @param lines The list of phone numbers.
     * @return The count of invalid phone numbers.
     */
    static public int numberOfInvalidNumbers(List<String> lines) {
        return (int) lines.stream().filter(line -> !isNumberValid(line)).count();
    }

    /**
     * Returns a list of valid phone numbers from the given list.
     *
     * @param lines The list of phone numbers.
     * @return A list of valid phone numbers.
     */
    static public List<String> listOfValidNumbers(List<String> lines) {
        return lines.stream().filter(PhoneStatic::isNumberValid).toList();
    }
}
