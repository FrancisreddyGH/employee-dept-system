// DepartmentService.java
package com.example.employeemanagementsystem.Service;

import com.example.employeemanagementsystem.Dto.DepartmentDto;
import com.example.employeemanagementsystem.Entity.Department;
import com.example.employeemanagementsystem.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public String createDepartment(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setName(departmentDto.getName());
        departmentRepository.save(department);
        return departmentDto.getName() + " department created successfully";
    }

    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public String updateDepartment(Long id, DepartmentDto departmentDto) {
        if (departmentRepository.existsById(id)) {
            Department department = departmentRepository.findById(id).get();
            department.setName(departmentDto.getName());
            departmentRepository.save(department);
            return "department updated successfully";
        } else {
            return "couldn't find department with id " + id;
        }
    }

    public String deleteDepartment(Long id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return "department with id " + id + " has been deleted";
        } else {
            return "department with id " + id + " is not found";
        }
    }
}