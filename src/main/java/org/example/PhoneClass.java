package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.logging.Logger;

/**
 * This class represents a phone number utility.
 */
public class PhoneClass {

    /**
     * List of lines read from the file.
     */
    public List<String> lines = null;

    /**
     * Regular expression pattern to validate phone numbers.
     * Matches US phone numbers in the following formats:
     * (123) 456-7890, 123 456 7890, 123-456-7890
     */
    public static final Pattern REGEX_VALID_PHONE_NUMBER = Pattern.compile("(\\(\\d{3}\\)\\s{1}\\d{3}-{1}\\d{4})|(\\d{3}\\s{1}\\d{3}\\s{1}\\d{4})|(\\d{3}-{1}\\d{3}-\\d{4})");

    /**
     * Logger for logging errors.
     */
    private static final Logger LOGGER = Logger.getLogger(PhoneClass.class.getName());

    /**
     * Reads all lines from the file and stores them in the 'lines' field.
     */
    public void readAllLinesAndStoreInField() {
        try {
            Path file = Paths.get("src/main/resources/fileTest.txt");
            lines = Files.readAllLines(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            LOGGER.severe("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Removes lines that start with a hash (#) symbol.
     * @return true if any comments are removed, false otherwise.
     */
    public boolean removeComments() {
        int count = 0;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).startsWith("#")) {
                lines.remove(i);
                count++;
                i--;
            }
        }
        return count > 0;
    }

    /**
     * Removes empty lines from the 'lines' field.
     * @return true if any empty lines are removed, false otherwise.
     */
    public boolean removeEmptyLines() {
        int count = 0;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).isEmpty()) {
                lines.remove(i);
                count++;
                i--;
            }
        }
        return count > 0;
    }

    /**
     * Returns the number of lines in the 'lines' field.
     * @return the number of lines.
     */
    public int numberOfLines() {
        return lines.size();
    }

    /**
     * Checks if a given number matches the REGEX_VALID_PHONE_NUMBER pattern.
     * @param number the phone number to validate.
     * @return true if the number is valid, false otherwise.
     */
    public boolean isNumberValid(String number) {
        return REGEX_VALID_PHONE_NUMBER.matcher(number).matches();
    }

    /**
     * Returns the number of valid phone numbers in the 'lines' field.
     * @return the number of valid phone numbers.
     */
    public int numberOfValidNumbers() {
        return (int) lines.stream().filter(this::isNumberValid).count();
    }

    /**
     * Returns the number of invalid phone numbers in the 'lines' field.
     * @return the number of invalid phone numbers.
     */
    public int numberOfInvalidNumbers() {
        return (int) lines.stream().filter(line ->!isNumberValid(line)).count();
    }

    /**
     * Returns a list of valid phone numbers from the 'lines' field.
     * @return a list of valid phone numbers.
     */
    public List<String> listOfValidNumbers() {
        return lines.stream().filter(this::isNumberValid).toList();
    }
}
