// DepartmentRepository.java
package com.example.employeemanagementsystem.Repositories;

import com.example.employeemanagementsystem.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}