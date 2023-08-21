package ru.netology;

public class PersonBuilder implements IPersonBuilder {

    private String name;
    private String surname;
    private int age;
    private String adress;

    public PersonBuilder() {
        super();

    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0)
            throw new IllegalArgumentException("Возраст не может быть отрицательной величиной.");

        this.age = age;
        return this;
    }

    public PersonBuilder setAdress(String adress) {
        this.adress = adress;
        return this;
    }

    public Person build() {
        if (name == null || name == "" || surname == null || surname == "")
            throw new IllegalStateException("Не заданы обязательные поля. Объект не может быть создан.");

        Person person = new Person(this.name, this.surname, this.age);
        person.setAdress(this.adress);

        return person;
    }
}
