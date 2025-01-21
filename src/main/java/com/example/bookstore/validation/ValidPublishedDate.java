package com.example.bookstore.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PublishedDateValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPublishedDate {

    String message() default "Published date must be between 1000 and the current year";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
