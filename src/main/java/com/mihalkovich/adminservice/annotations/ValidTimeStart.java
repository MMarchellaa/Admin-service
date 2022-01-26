package com.mihalkovich.adminservice.annotations;

import com.mihalkovich.adminservice.validations.StartTimeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StartTimeValidator.class)
@Documented
public @interface ValidTimeStart {
    String message() default "Wrong time or format";

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default {};
}
