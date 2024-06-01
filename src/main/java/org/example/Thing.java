package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Thing {

    public List<String> lines = null;

    public void readAllLinesAndStoreInField() {
        try {
            Path file = Paths.get("src/main/resources/fileTest.txt");
            lines = Files.readAllLines(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static public List<String> readAllLinesAndReturn() {
        try {
            Path file = Paths.get("src/main/resources/fileTest.txt");
            return Files.readAllLines(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    /*
    file = getFile("location");
    validNumbers = getValidNums(file);
    invalidNumbers = getInvalidNums(file);
    int numNums = getNumOfNums(file);
     */

//    static String readFromInputStream(InputStream inputStream)
//            throws IOException {
//        StringBuilder resultStringBuilder = new StringBuilder();
//        try (BufferedReader br
//                     = new BufferedReader(new InputStreamReader(inputStream))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                resultStringBuilder.append(line).append("\n");
//            }
//        }
//        return resultStringBuilder.toString();
//    }
}
