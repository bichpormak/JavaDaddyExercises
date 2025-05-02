package com.bichpormak;

public class AgeChecker {

    public static void main(String[] args) {

        int age = 155;

        try {
            checkAge(age);
            System.out.println("Норм возраст");
        } catch (InvalidAgeException e) {
            System.out.println("Огромный возраст");
        }

    }

    private static void checkAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException();
        }

    }

}