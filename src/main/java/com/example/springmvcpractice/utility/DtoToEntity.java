package com.example.springmvcpractice.utility;

import com.example.springmvcpractice.dto.EmployeeDTO;
import com.example.springmvcpractice.dto.PilgrimDTO;
import com.example.springmvcpractice.entity.Employee;
import com.example.springmvcpractice.entity.Pilgrim;

public class DtoToEntity {

    public static Employee employeeDtoToEmployee(EmployeeDTO employeeDTO) {
        return new Employee(employeeDTO.getEmpName(),employeeDTO.getDepartment());
    }

    public static Pilgrim pilgrimDtoToPilgrim(PilgrimDTO pilgrimDTO) {
        return new Pilgrim(pilgrimDTO.getName(),pilgrimDTO.getMobileNumber(),pilgrimDTO.getAddress());
    }
}
