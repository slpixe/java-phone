package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

public class ThingClass {

    public List<String> lines = null;
    public static final Pattern REGEX_VALID_PHONE_NUMBER = Pattern.compile("(\\(\\d{3}\\)\\s{1}\\d{3}-{1}\\d{4})|(\\d{3}\\s{1}\\d{3}\\s{1}\\d{4})|(\\d{3}-{1}\\d{3}-\\d{4})");

    public void readAllLinesAndStoreInField() {
        try {
            Path file = Paths.get("src/main/resources/fileTest.txt");
            lines = Files.readAllLines(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean removeComments() {
        // iterate over lines, and if the line starts with a hash # then remove that line, if any comments are removed return true
        // otherwise return false
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

    public Boolean removeEmptyLines() {
        // iterate over lines, and if the line is empty then remove that line, if any empty lines are removed return true
        // otherwise return false
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

    public Integer numberOfLines() {
        //return the number of lines
        System.out.println(lines);
        return lines.size();
    }

    public boolean isNumberValid(String number) {
        //if number matches the regex return true, otherwise return false
        return REGEX_VALID_PHONE_NUMBER.matcher(number).matches();
    }

    public Integer numberOfValidNumbers() {
        //return the number of valid phone numbers
        return (int) lines.stream().filter(this::isNumberValid).count();
    }

    public Integer numberOfInvalidNumbers() {
        //return the number of invalid phone numbers
        return (int) lines.stream().filter(line ->!isNumberValid(line)).count();
    }

    /*
    file = getFile("location");
    validNumbers = getValidNums(file);
    invalidNumbers = getInvalidNums(file);
    int numNums = getNumOfNums(file);
     */
}
