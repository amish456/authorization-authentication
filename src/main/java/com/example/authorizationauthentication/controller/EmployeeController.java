package com.example.authorizationauthentication.controller;

import com.example.authorizationauthentication.payload.EmployeeDto;
import com.example.authorizationauthentication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    @PreAuthorize(value = "hasRole('ADMIN')")
//    @PostAuthorize(value = "hasRole('ADMIN')")
    @PostMapping("/add")
    private ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.addEmployee(employeeDto), HttpStatus.OK);
    }

    @GetMapping("/get")
    private List<EmployeeDto> getAllEmployees(){
        return employeeService.getAllEmployees();
    }


}
