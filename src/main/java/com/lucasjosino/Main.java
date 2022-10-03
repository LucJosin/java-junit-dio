package com.lucasjosino;

import com.lucasjosino.enums.BankName;
import com.lucasjosino.enums.BankStatus;
import com.lucasjosino.models.Account;
import com.lucasjosino.models.Person;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        personMain();

        bankMain();
    }

    private static void bankMain() {
        Bank bank = new Bank();

        Random random = new Random();

        Account from = new Account(
                "John Doe",
                UUID.randomUUID(),
                random.nextInt(100),
                BankName.BANK_OF_SELENE,
                "305983985718758093",
                List.of(BankStatus.ACTIVE),
                521.8f,
                1000f
        );

        Account to = new Account(
                "Maria Doe",
                UUID.randomUUID(),
                random.nextInt(100),
                BankName.BANK_OF_SELENE,
                "317194531987534611",
                List.of(BankStatus.ACTIVE),
                217.1f,
                1000f
        );

        bank.createAccount(from);
        bank.createAccount(to);

        try {
            bank.transfer(from, to, 358.9f);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(from);
        System.out.println(to);
    }

    private static void personMain() {
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