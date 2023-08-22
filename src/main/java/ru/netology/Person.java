package ru.netology;

import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private OptionalInt age;
    private String adress;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.empty();
    }

    public Person(String name, String surname, int age) {

        if (age < 0) {
            throw new IllegalArgumentException("Age может быть только положительным числом");
        }

        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }

    public void happyBirthday() {
        if (hasAge()) {
            this.age = OptionalInt.of(this.age.getAsInt() + 1);
        } else {
            throw new IllegalStateException(String.format("Возраст персоны [%s %s] не задан", this.surname, this.name));
        }
    }

    public boolean hasAdress() {
        return (this.adress != null && this.adress != "") ? true : false;
    }

    public boolean hasAge() {
        return (this.age.isPresent()) ? true : false;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder.setSurname(this.surname);
        personBuilder.setAdress(this.adress);
        personBuilder.setAge(0);

        return personBuilder;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public int hashCode() {
        if (!hasAdress())
            this.adress = "";

        return String.join(" ", this.name, this.surname, Integer.toString(this.age.getAsInt()), this.adress)
                .hashCode();
    }

    @Override
    public String toString() {
        return "Person:\r" +
                "\nname    = " + this.name +
                "\nsurname = " + this.surname +
                "\nage     = " + Integer.toString(this.age.getAsInt()) +
                "\nadress  = " + this.adress;
    }
}
