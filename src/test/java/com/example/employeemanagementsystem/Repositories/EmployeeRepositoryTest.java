// EmployeeRepositoryTest.java
package com.example.employeemanagementsystem.Repositories;

import com.example.employeemanagementsystem.Entity.Employee;
import com.example.employeemanagementsystem.Entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    private Employee employee;
    private Department department;

    @BeforeEach
    void setUp() {
        department = new Department();
        department.setName("IT");
        department.setIs_active(true);
        departmentRepository.save(department);

        employee = new Employee();
        employee.setName("John Doe");
        employee.setEmail("john@example.com");
        employee.setSalary(50000.0);
        employee.setDepartment(department);
        employee.setIs_active(true);
    }

    @Test
    void testSaveEmployee() {
        Employee savedEmployee = employeeRepository.save(employee);
        assertNotNull(savedEmployee);
        assertNotNull(savedEmployee.getId());
        assertEquals("John Doe", savedEmployee.getName());
    }

    @Test
    void testFindEmployeeById() {
        Employee savedEmployee = employeeRepository.save(employee);
        Employee foundEmployee = employeeRepository.findById(savedEmployee.getId()).orElse(null);
        assertNotNull(foundEmployee);
        assertEquals("John Doe", foundEmployee.getName());
    }

    @Test
    void testUpdateEmployee() {
        Employee savedEmployee = employeeRepository.save(employee);
        savedEmployee.setName("Jane Doe");
        Employee updatedEmployee = employeeRepository.save(savedEmployee);
        assertEquals("Jane Doe", updatedEmployee.getName());
    }

    @Test
    void testDeleteEmployee() {
        Employee savedEmployee = employeeRepository.save(employee);
        Long employeeId = savedEmployee.getId();
        employeeRepository.deleteById(employeeId);
        assertFalse(employeeRepository.existsById(employeeId));
    }

    @Test
    void testGetAllEmployees() {
        employeeRepository.save(employee);
        Employee employee2 = new Employee();
        employee2.setName("Jane Smith");
        employee2.setEmail("jane@example.com");
        employee2.setSalary(45000.0);
        employee2.setDepartment(department);
        employee2.setIs_active(true);
        employeeRepository.save(employee2);

        long count = employeeRepository.count();
        assertTrue(count >= 2);
    }

    @Test
    void testEmployeeWithDepartment() {
        Employee savedEmployee = employeeRepository.save(employee);
        assertNotNull(savedEmployee.getDepartment());
        assertEquals("IT", savedEmployee.getDepartment().getName());
    }

    @Test
    void testGetEmployeesWithDepartment() {
        employeeRepository.save(employee);
        List<Employee> employees = employeeRepository.getEmployeesWithDepartment();
        assertFalse(employees.isEmpty());
    }

    @Test
    void testEmployeeExistsById() {
        Employee savedEmployee = employeeRepository.save(employee);
        assertTrue(employeeRepository.existsById(savedEmployee.getId()));
    }

    @Test
    void testEmployeeNotFound() {
        assertFalse(employeeRepository.findById(9999L).isPresent());
    }
}