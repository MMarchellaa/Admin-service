package com.mihalkovich.adminservice.validations;

import com.mihalkovich.adminservice.annotations.ValidDuration;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalTime;

public class DurationValidator implements ConstraintValidator<ValidDuration, LocalTime> {

    @Override
    public void initialize(ValidDuration constraintAnnotation) {

    }

    @Override
    public boolean isValid(LocalTime time, ConstraintValidatorContext context) {
        return validateStartTime(time);
    }

    private boolean validateStartTime(LocalTime time) {
        return !((time.isBefore(LocalTime.of(0, 45))) || time.isAfter(LocalTime.of(2, 0)));
    }
}
