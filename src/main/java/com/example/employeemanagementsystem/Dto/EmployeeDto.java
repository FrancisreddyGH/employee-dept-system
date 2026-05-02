// EmployeeDto.java
package com.example.employeemanagementsystem.Dto;

import com.example.employeemanagementsystem.Entity.Department;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDto {
    private String name;
    private String email;
    private Double salary;
    private Department department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}