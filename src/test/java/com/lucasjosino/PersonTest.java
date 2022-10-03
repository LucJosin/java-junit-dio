package com.lucasjosino;

import com.lucasjosino.models.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Objects;

public class PersonTest {

    private final Person person = new Person("John Doe", LocalDate.of(1997, 4, 21));

    @Test
    void hasACorrectAge() {
        Assertions.assertEquals(25, person.getAge());
    }

    @Test
    void isUnderAge() {
        Assertions.assertFalse(person.isUnderage());

        Person newPerson = new Person("John Nick", LocalDate.of(2005, 4, 21));
        Assertions.assertTrue(newPerson.isUnderage());
    }

    @Test
    void hasACorrectBirthDate() {
        LocalDate date = LocalDate.of(1997, 4, 21);
        Assertions.assertEquals(person.getBirthDate(), date);
    }
}
