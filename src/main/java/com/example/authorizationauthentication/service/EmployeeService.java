package com.example.authorizationauthentication.service;

import com.example.authorizationauthentication.payload.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto addEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> getAllEmployees();

}
