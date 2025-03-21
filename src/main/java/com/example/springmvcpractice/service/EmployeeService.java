package com.example.springmvcpractice.service;

import com.example.springmvcpractice.dto.EmployeeDTO;
import com.example.springmvcpractice.entity.Employee;
import com.example.springmvcpractice.repository.EmployeeRepository;
import com.example.springmvcpractice.utility.DtoToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = DtoToEntity.employeeDtoToEmployee(employeeDTO);
        return employeeRepository.save(employee);
    }

    public Employee getEmployee(int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        } else {
            throw new NoSuchElementException("Employee Not Found With Id " + id);
        }
    }
}

