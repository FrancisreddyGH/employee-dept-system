// DepartmentDto.java
package com.example.employeemanagementsystem.Dto;

import org.springframework.stereotype.Component;

@Component
public class DepartmentDto {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}