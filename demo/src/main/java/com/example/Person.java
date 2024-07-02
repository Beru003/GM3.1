package com.example;

import javafx.beans.property.*;

public class Person {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final IntegerProperty id;
    private final IntegerProperty number;

    public Person(String firstName, String lastName, int id) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.id = new SimpleIntegerProperty(id);
        this.number = new SimpleIntegerProperty();
    }

    public Person(String firstName, String lastName, int id, int number) {
        this(firstName, lastName, id);
        this.number.set(number);
    }

    // Getters and setters for firstName
    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    // Getters and setters for lastName
    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    // Getters and setters for id
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    // Getters for number
    public int getNumber() {
        return number.get();
    }

    public IntegerProperty numberProperty() {
        return number;
    }
}
