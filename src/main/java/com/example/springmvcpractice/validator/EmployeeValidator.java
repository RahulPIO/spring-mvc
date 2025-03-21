package com.example.springmvcpractice.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmployeeFieldValidator.class)
public @interface EmployeeValidator {
    String message() default "Invalid Department Name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
