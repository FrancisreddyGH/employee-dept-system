// DepartmentRepositoryTest.java
package com.example.employeemanagementsystem.Repositories;

import com.example.employeemanagementsystem.Entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    private Department department;

    @BeforeEach
    void setUp() {
        department = new Department();
        department.setName("IT");
        department.setIs_active(true);
    }

    @Test
    void testSaveDepartment() {
        Department saveddepartment = departmentRepository.save(department);
        assertNotNull(saveddepartment);
        assertNotNull(saveddepartment.getId());
        assertEquals("IT", saveddepartment.getName());
    }

    @Test
    void testFindDepartmentById() {
        Department saveddepartment = departmentRepository.save(department);
        Department founddepartment = departmentRepository.findById(saveddepartment.getId()).orElse(null);
        assertNotNull(founddepartment);
        assertEquals("IT", founddepartment.getName());
    }

    @Test
    void testUpdateDepartment() {
        Department saveddepartment = departmentRepository.save(department);
        saveddepartment.setName("HR");
        Department updateddepartment = departmentRepository.save(saveddepartment);
        assertEquals("HR", updateddepartment.getName());
    }

    @Test
    void testDeleteDepartment() {
        Department saveddepartment = departmentRepository.save(department);
        Long departmentId = saveddepartment.getId();
        departmentRepository.deleteById(departmentId);
        assertFalse(departmentRepository.existsById(departmentId));
    }

    @Test
    void testGetAllDepartments() {
        departmentRepository.save(department);
        Department department2 = new Department();
        department2.setName("HR");
        department2.setIs_active(true);
        departmentRepository.save(department2);

        long count = departmentRepository.count();
        assertTrue(count >= 2);
    }

    @Test
    void testDepartmentExistsById() {
        Department saveddepartment = departmentRepository.save(department);
        assertTrue(departmentRepository.existsById(saveddepartment.getId()));
    }

    @Test
    void testDepartmentNotFound() {
        assertFalse(departmentRepository.findById(9999L).isPresent());
    }
}