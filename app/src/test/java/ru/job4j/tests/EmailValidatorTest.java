package ru.job4j.tests;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EmailValidatorTest {
    private Validator<String> validator;

    @Before
    public void before() {
        validator = new EmailValidator();
    }

    @Test
    public void whenEmailsNotValid() {
        String email = "";
        assertThat(validator.validate(email)).isFalse();
    }

    @Test
    public void whenEmailsValid() {
        String email = "test@test.com";
        assertThat(validator.validate(email)).isTrue();
    }

    @Test
    public void whenEmailWrong() {
        String email = "test@tet.com";
        assertThat(validator.validate(email)).isFalse();
    }
}