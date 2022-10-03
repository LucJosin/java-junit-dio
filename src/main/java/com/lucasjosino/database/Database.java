package com.lucasjosino.database;

import com.lucasjosino.exceptions.DatabaseConnectionException;
import com.lucasjosino.models.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Database {

    private boolean isConnected = false;

    private final List<Person> persons = new ArrayList<>() {{
        add(new Person("John Doe", LocalDate.of(1997, 4, 21)));
        add(new Person("Maria Doe", LocalDate.of(2000, 8, 5)));
        add(new Person("Janny Doe", LocalDate.of(2005, 7, 14)));
        add(new Person("Clara Doe", LocalDate.of(2013, 1, 9)));
    }};

    public void OpenConnection() throws InterruptedException {
        // First, check if database is already connected.
        //
        // If true, just return.
        if (isConnected) {
            System.out.println("Database already connected to the database!");
            return;
        }

        // Fake database connection of 3 seconds.
        Thread.sleep(3000);

        // Connected.
        isConnected = true;
        System.out.println("Connected to the database.");
    }

    public boolean CloseConnection() throws Exception {
        // Check if database is connected.
        //
        // If true, disconnect.
        if (isConnected) {
            Thread.sleep(1000);
            isConnected = false;
            return true;
        }

        // If database is not connected. Throw an exception.
        throw new DatabaseConnectionException("Database is not connected!");
    }

    public boolean IsConnected() {
        return isConnected;
    }

    public List<Person> GetAllPerson() {
        return persons;
    }

    public void RemovePerson(int index) {
        try {
            persons.remove(index);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Person GetPerson(String name) {
        for (Person person : persons) {
            if (Objects.equals(person.getName(), name)) return person;
        }
        return null;
    }

    public void AddPerson(Person person) {
        try {
            persons.add(person);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
