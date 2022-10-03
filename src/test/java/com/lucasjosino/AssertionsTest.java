package com.lucasjosino;

import com.lucasjosino.models.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AssertionsTest {

    private final int[] firstArray = {10, 20, 30, 40, 50};
    private final int[] secondArray = {10, 20, 30, 40, 50};

    @Test
    void arraysShouldBeEquals() {
        Assertions.assertArrayEquals(firstArray, secondArray);
    }

    @Test
    void arraysShouldNotBeEquals() {
        Assertions.assertNotEquals(firstArray, secondArray);
    }

    // Test only
    private Person getPerson() {
        return null;
    }

    @Test
    void validateNullObject() {
        // Get a null person.
        Person person = getPerson();

        // Check nullable object.
        Assertions.assertNull(person);

        // Convert object in not null.
        person = new Person("John Doe", LocalDate.of(1997, 4, 21));

        // Check not null object.
        Assertions.assertNotNull(person);
    }

    @Test
    void validateTypesOfNumbers() {
        double value1 = 0;
        double value2 = 7.0;

        Assertions.assertNotEquals(value1, value2);

        value1 = 7.0;

        Assertions.assertEquals(value1, value2);
    }
}
