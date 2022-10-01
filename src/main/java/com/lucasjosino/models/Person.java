package com.lucasjosino.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person {
    private String name;
    private LocalDate birthDate;

    public Person() {}

    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getAge() {
        return (int) ChronoUnit.YEARS.between(this.birthDate, LocalDate.now());
    }

    public boolean isUnderage() {
        return getAge() < 18;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
