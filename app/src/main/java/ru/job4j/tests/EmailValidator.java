package ru.job4j.tests;

public class EmailValidator implements Validator {
    @Override
    public boolean validate(Object value) {
        return value.equals("test@test.com");
    }
}
