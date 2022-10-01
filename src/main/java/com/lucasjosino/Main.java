package com.lucasjosino;

import com.lucasjosino.models.Person;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Create new person.
        Person firstPerson = new Person();

        // Define name and birthdate.
        firstPerson.setName("Johnny Yee");
        firstPerson.setBirthDate(LocalDate.of(2000, 7, 8));

        // Create new person.
        Person secondPerson = new Person();

        // Define name and birthdate.
        secondPerson.setName("Maria Yee");
        secondPerson.setBirthDate(LocalDate.of(2008, 4, 26));

        // Show first person.
        printPersonInfo(firstPerson);

        System.out.println("");

        // Show second person.
        printPersonInfo(secondPerson);
    }

    private static void printPersonInfo(Person person) {
        // Show person information.
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Birthdate: " + person.getBirthDate());
        System.out.println("is Underage: " + person.isUnderage());
    }
}