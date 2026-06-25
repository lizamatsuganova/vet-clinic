package com.example.vetclinic.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {
    private static final int MIN_LENGTH = 8;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        boolean lengthOk = value.length() >= MIN_LENGTH;
        boolean hasLetter = value.matches(".*[A-Za-zА-Яа-я].*");
        boolean hasDigit = value.matches(".*\\d.*");
        boolean hasSpecial = value.matches(".*[^A-Za-zА-Яа-я0-9].*");
        return lengthOk && hasLetter && hasDigit && hasSpecial;
    }
}
