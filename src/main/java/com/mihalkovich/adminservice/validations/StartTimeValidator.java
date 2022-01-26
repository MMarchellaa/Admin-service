package com.mihalkovich.adminservice.validations;

import com.mihalkovich.adminservice.annotations.ValidTimeStart;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalTime;

public class StartTimeValidator implements ConstraintValidator<ValidTimeStart, LocalTime> {

    @Override
    public void initialize(ValidTimeStart constraintAnnotation) {

    }

    @Override
    public boolean isValid(LocalTime time, ConstraintValidatorContext context) {
        return validateStartTime(time);
    }

    private boolean validateStartTime(LocalTime time) {
        return !((time.isBefore(LocalTime.of(8, 0))) || time.isAfter(LocalTime.of(20, 0)));
    }
}
