package com.techbizz.westminster.classpractise.demo.productapi;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    private int id;
    private String name;
    private LocalDate birthDate;


    public Person(int id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    String calculateAge() {
        LocalDate now = LocalDate.now();
        Period period = Period.between(birthDate, now);
        int years = period.getYears();
        return String.join(" ", "Person born in", this.birthDate.toString(), "is", String.valueOf(years), "old today");
    }
}
