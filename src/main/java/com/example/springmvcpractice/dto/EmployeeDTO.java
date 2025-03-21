package com.example.springmvcpractice.dto;

import com.example.springmvcpractice.constants.ValueConstants;
import com.example.springmvcpractice.validator.EmployeeValidator;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EmployeeDTO {
   @Size(min=ValueConstants.MIN_VAL,max=ValueConstants.MAX_VAL,message = "Name length should be between {min} and {max}")
    private String empName;
    @EmployeeValidator
    private String department;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String empName, String department) {
        this.empName = empName;
        this.department = department;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
