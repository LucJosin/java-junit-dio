package com.lucasjosino;

import com.lucasjosino.database.Database;
import com.lucasjosino.models.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Random;

public class DatabaseTest {

    static Database db = new Database();

    private final Person newPerson = new Person("Joana Doe", LocalDate.of(2018, 3, 11));

    @BeforeAll
    static void Connect() {
        try {
            db.OpenConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    @Test
    void databaseShouldBeConnected() {
        Assertions.assertTrue(db.IsConnected());
    }

    @Test
    void databaseShouldNotBeEmpty() {
        Assertions.assertFalse(db.GetAllPerson().isEmpty());

        Assertions.assertEquals(4, db.GetAllPerson().size());
    }

    @Test
    void shouldRemoveOneItemFromDatabase() {
        int newIndex = new Random().nextInt(3);

        db.RemovePerson(newIndex);

        Assertions.assertEquals(3, db.GetAllPerson().size());
    }

    @Test
    void shouldAddTwoItemsToDatabase() {
        db.AddPerson(newPerson);
        Assertions.assertEquals(4, db.GetAllPerson().size());
    }

    @Test
    void shouldReturnASinglePerson() {
        Assertions.assertEquals(newPerson, db.GetPerson(newPerson.getName()));
    }

    @Test
    void databaseShouldDisconnect() {
        try {
            Assertions.assertTrue(db.CloseConnection());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void databaseShouldBeDisconnected() {
        Assertions.assertFalse(db.IsConnected());
    }
}
