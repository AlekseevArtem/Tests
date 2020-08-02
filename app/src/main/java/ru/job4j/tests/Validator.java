package ru.job4j.tests;

public interface Validator<T> {
    boolean validate(T value);
}