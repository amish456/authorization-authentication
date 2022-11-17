package com.example.authorizationauthentication.service.impl;

import com.example.authorizationauthentication.entity.Employee;
import com.example.authorizationauthentication.payload.EmployeeDto;
import com.example.authorizationauthentication.repository.EmployeeRepository;
import com.example.authorizationauthentication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Employee employee = mapToEntity(employeeDto);
        Employee newEmployee = employeeRepository.save(employee);
        return mapToDto(newEmployee);



    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private EmployeeDto mapToDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setCity(employee.getCity());
        employeeDto.setTech(employee.getTech());
        employeeDto.setMobile(employee.getMobile());
        employeeDto.setDept(employee.getDept());
        employeeDto.setName(employee.getName());
        return employeeDto;
    }

    private Employee mapToEntity(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setCity(employeeDto.getCity());
        employee.setTech(employeeDto.getTech());
        employee.setMobile(employeeDto.getMobile());
        employee.setDept(employeeDto.getDept());
        employee.setName(employeeDto.getName());
        return employee;
    }
}
