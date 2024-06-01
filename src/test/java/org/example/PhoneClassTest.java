package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

class PhoneClassTest {
    @Test
    public void readAllLinesFromField() {
        //arrange
        PhoneClass thing = new PhoneClass();

        //act
        thing.readAllLinesAndStoreInField();

        //assert
        assertThat(thing.lines.size(), greaterThan(5));
        assertThat(thing.lines.get(0), equalTo("#Valid phone numbers:"));
    }

    @Test
    void removeComments() {
        //arrange
        PhoneClass thing = new PhoneClass();

        //act
        thing.readAllLinesAndStoreInField();
        int oldLines = thing.lines.size();
        boolean removed = thing.removeComments();
        int newLines = thing.lines.size();
        boolean removedSecondTime = thing.removeComments();

        // assert
        // that newLines is less than oldLines
        Assertions.assertTrue(newLines < oldLines);
        Assertions.assertTrue(removed);
        Assertions.assertFalse(removedSecondTime);
    }

    @Test
    void isNumberValid() {
        //arrange
        PhoneClass thing = new PhoneClass();
        List<String> validNumbers = List.of("(123) 456-7890", "987-654-3210", "(555) 123-4567", "123 456 7890", "555 987 6543");
        List<String> invalidNumbers = List.of("123-4567", "(123) 456-789", "987-654-321", "(555) 123-45678", "555-987-65432");

        //act
        //thing.readAllLinesAndStoreInField();
        boolean valid = thing.isNumberValid("123-456-7890");
        boolean invalid = thing.isNumberValid("123-456-789");

        //assert
        Assertions.assertTrue(valid);
        Assertions.assertFalse(invalid);
        Assertions.assertTrue(validNumbers.stream().allMatch(thing::isNumberValid));
        Assertions.assertTrue(invalidNumbers.stream().noneMatch(thing::isNumberValid));
    }

    @Test
    void numberOfValidNumbers() {
        // arrange
//        List<String> validAndInvalidNumbers = List.of("(123) 456-7890", "987-654-3210", "(555) 123-4567", "123 456 7890", "555 987 6543", "123-4567", "(123) 456-789", "987-654-321", "(555) 123-45678", "555-987-65432");
        PhoneClass thing = new PhoneClass();
        thing.readAllLinesAndStoreInField();
        thing.removeComments();
        Boolean RemoveHappened = thing.removeEmptyLines();

        // act
        Integer validNumbers = thing.numberOfValidNumbers();

        // assert
        Assertions.assertEquals(10, thing.numberOfLines());
        Assertions.assertEquals(5, validNumbers);
        Assertions.assertTrue(RemoveHappened);
    }

    @Test
    void numberOfInvalidNumbers() {
        // arrange
        PhoneClass thing = new PhoneClass();
        thing.readAllLinesAndStoreInField();
        thing.removeComments();
        thing.removeEmptyLines();

        // act
        Integer invalidNumbers = thing.numberOfInvalidNumbers();

        // assert
        Assertions.assertEquals(5, invalidNumbers);
    }

    @Test
    void listOfValidNumbers() {
        // arrange
        PhoneClass thing = new PhoneClass();
        thing.readAllLinesAndStoreInField();
        thing.removeComments();
        thing.removeEmptyLines();

        // act
        List<String> validNumbers = thing.listOfValidNumbers();

        // assert
        Assertions.assertEquals(10, thing.numberOfLines());
        Assertions.assertEquals(5, validNumbers.size());
        Assertions.assertTrue(validNumbers.containsAll(List.of("(123) 456-7890", "987-654-3210", "(555) 123-4567", "123 456 7890", "555 987 6543")));
    }
}