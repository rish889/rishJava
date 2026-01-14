package org.rish889;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void shouldFailWhenLengthIsLessThanEight() {
        assertFalse(PasswordValidator.isValid("Ab1"), "Password shorter than 8 characters should be invalid");
    }

    @Test
    void shouldFailWhenMissingUppercase() {
        assertFalse(PasswordValidator.isValid("password123"), "Password without uppercase should be invalid");
    }

    @Test
    void shouldFailWhenMissingLowercase() {
        assertFalse(PasswordValidator.isValid("PASSWORD123"), "Password without lowercase should be invalid");
    }

    @Test
    void shouldFailWhenMissingDigit() {
        assertFalse(PasswordValidator.isValid("Password"), "Password without digit should be invalid");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Abcdefg1", "StrongPass7", "Valid1Password"})
    void shouldSucceedWithValidPasswords(String password) {
        assertTrue(PasswordValidator.isValid(password), "Password meeting all criteria should be valid");
    }
}
