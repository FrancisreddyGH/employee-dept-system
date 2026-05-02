// EmployeeRepository.java
package com.example.employeemanagementsystem.Repositories;

import com.example.employeemanagementsystem.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e INNER JOIN FETCH e.department d")
    List<Employee> getEmployeesWithDepartment();
}