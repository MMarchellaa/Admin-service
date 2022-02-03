package com.mihalkovich.adminservice.annotations;

import com.mihalkovich.adminservice.validations.DurationValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DurationValidator.class)
@Documented
public @interface ValidDuration {
    String message() default "Wrong duration";

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default {};
}
