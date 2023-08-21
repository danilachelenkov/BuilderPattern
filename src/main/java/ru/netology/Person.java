package ru.netology;

public class Person {
    protected final String name;
    protected final String surname;
    private int age;
    private String adress;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = -1;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = (age < 0) ? 0 : age;
    }

    public void happyBirthday() {
        if (hasAge()) this.age++;
    }

    public boolean hasAdress() {
        return (this.adress != null && this.adress != "") ? true : false;
    }

    public boolean hasAge() {
        return (this.age >= 0) ? true : false;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder.setSurname(this.surname);
        personBuilder.setAdress(this.adress);
        personBuilder.setAge(10);

        return personBuilder;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
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
        if (!hasAdress()) this.adress = "";
        return String.join(this.name, this.surname, Integer.toString(this.age), this.adress)
                .hashCode();
    }

    @Override
    public String toString() {
        return "Person:\r" +
                "\nname = " + this.name +
                "\nsurname = " + this.surname +
                "\nage = " + Integer.toString(this.age) +
                "\nadress = " + this.adress;

    }
}
