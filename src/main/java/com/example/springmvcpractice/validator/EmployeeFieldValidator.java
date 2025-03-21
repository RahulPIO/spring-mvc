package com.example.springmvcpractice.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class EmployeeFieldValidator implements ConstraintValidator<EmployeeValidator, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        List<String> department = Arrays.asList("HR", "MARKETING", "PRODUCTION", "SALES");
        return department.contains(s);
    }
}
