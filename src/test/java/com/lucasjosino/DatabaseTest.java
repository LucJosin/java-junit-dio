package com.lucasjosino;

import com.lucasjosino.database.Database;
import com.lucasjosino.models.Person;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.Random;

public class DatabaseTest {

    static Database db = new Database();

    private final Person newPerson = new Person("Joana Doe", LocalDate.of(2018, 3, 11));

    @BeforeAll
    static void Connect() {
        System.out.println(1);
        try {
            db.openConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        Assertions.assertTrue(db.isConnected());
    }

    @Test
    void databaseShouldNotBeEmpty() {
        Assertions.assertFalse(db.getAllPerson().isEmpty());
        Assertions.assertEquals(4, db.getAllPerson().size());
    }

    @Test
    void shouldRemoveOneItemFromDatabase() {
        // Get random number.
        int newIndex = new Random().nextInt(4);

        // Remove the person using an index.
        db.removePerson(newIndex);

        Assertions.assertEquals(4, db.getAllPerson().size());
    }

    @Test
    void shouldAddTwoItemsToDatabase() {
        // Add a person to the database.
        db.addPerson(newPerson);

        Assertions.assertEquals(5, db.getAllPerson().size());
    }

    @Test
    void shouldReturnASinglePerson() {
        // Get a single person using the name.
        Person cPerson = db.getPerson(newPerson.getName());

        Assertions.assertEquals(newPerson.getName(), cPerson.getName());
        Assertions.assertEquals(newPerson.getBirthDate(), cPerson.getBirthDate());
        Assertions.assertEquals(newPerson.getAge(), cPerson.getAge());
    }

    @AfterAll
    static void databaseShouldDisconnect() {
        try {
            Assertions.assertTrue(db.closeConnection());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        Assertions.assertFalse(db.isConnected());
    }
}
