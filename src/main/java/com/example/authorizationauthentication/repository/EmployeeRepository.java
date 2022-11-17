package com.example.authorizationauthentication.repository;

import com.example.authorizationauthentication.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
