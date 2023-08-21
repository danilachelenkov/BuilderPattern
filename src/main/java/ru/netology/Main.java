package ru.netology;

public class Main {
    public static void main(String[] args) {

        Person mama = new PersonBuilder()
                .setName("Агафья")
                .setSurname("Иванова")
                .setAge(47)
                .setAdress("Москва")
                .build();

        Person child = mama.newChildBuilder()
                .setName("Тарас")
                .build();

        System.out.println(mama.toString() + "\rимеет ребенка\r" + child.toString());

        try {
            new PersonBuilder().build();
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            mama.newChildBuilder()
                    .setName("Таня")
                    .setAge(-110)
                    .build();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}