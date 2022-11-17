package com.example.authorizationauthentication.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private long id;
    private String name;
    private String dept;
    private String mobile;
    private String city;
    private String tech;

}
