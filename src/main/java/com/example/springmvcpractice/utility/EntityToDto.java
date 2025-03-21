package com.example.springmvcpractice.utility;

import com.example.springmvcpractice.dto.EmployeeDTO;
import com.example.springmvcpractice.dto.PilgrimDTO;
import com.example.springmvcpractice.entity.Employee;
import com.example.springmvcpractice.entity.Pilgrim;

public class EntityToDto {

    public static EmployeeDTO employeeToEmployeeDto(Employee employee) {
        return new EmployeeDTO(employee.getEmpName(), employee.getDepartment());
    }

    public static PilgrimDTO pilgrimToPilgrimDto(Pilgrim pilgrim) {
        PilgrimDTO pilgrimDTO = new PilgrimDTO(pilgrim.getName(),pilgrim.getMobileNumber(),pilgrim.getAddress());
        pilgrimDTO.setId(pilgrim.getId());
        return pilgrimDTO;
    }

}
