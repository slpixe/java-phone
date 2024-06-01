package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ThingClass {

    public List<String> lines = null;

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

    /*
    file = getFile("location");
    validNumbers = getValidNums(file);
    invalidNumbers = getInvalidNums(file);
    int numNums = getNumOfNums(file);
     */
}
