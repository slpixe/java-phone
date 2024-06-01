package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

class ThingClassTest {
    @Test
    public void readAllLinesFromField() {
        //arrange
        List<String> expectedList = List.of("Hello, world!", "My Name is bob");
        ThingClass thing = new ThingClass();

        //act
        thing.readAllLinesAndStoreInField();

        //assert
        assertThat(thing.lines.size(), greaterThan(5));
        assertThat(thing.lines.get(0), equalTo("#Valid phone numbers:"));
    }

    @Test
    void removeComments() {
        //arrange
        ThingClass thing = new ThingClass();

        //act
        thing.readAllLinesAndStoreInField();
        int oldLines = thing.lines.size();
        thing.removeComments();
        int newLines = thing.lines.size();

        // assert
        // that newLines is less than oldLines
        Assertions.assertTrue(newLines < oldLines);
    }
}