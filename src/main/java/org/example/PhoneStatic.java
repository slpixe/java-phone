package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * This class represents a static utility for handling phone numbers.
 * It provides methods for reading phone numbers from a file and storing them in a list.
 */
public class PhoneStatic {

    /**
     * A list to store the lines of phone numbers read from the file.
     */
    public List<String> lines = null;

    /**
     * Default constructor.
     */
    PhoneStatic(){}

    /**
     * Reads all lines from the file "src/main/resources/fileTest.txt" and stores them in the 'lines' field.
     * If an IOException occurs during the reading process, it will be caught and printed to the console.
     */
    public void readAllLinesAndStoreInField() {
        try {
            Path file = Paths.get("src/main/resources/fileTest.txt");
            lines = Files.readAllLines(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads all lines from the file "src/main/resources/fileTest.txt" and returns them as a List.
     * If an IOException occurs during the reading process, it will be caught and printed to the console.
     * If an IOException occurs, an empty List will be returned.
     *
     * @return A List of strings representing the lines from the file.
     */
    static public List<String> readAllLinesAndReturn() {
        try {
            Path file = Paths.get("src/main/resources/fileTest.txt");
            return Files.readAllLines(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }
}
