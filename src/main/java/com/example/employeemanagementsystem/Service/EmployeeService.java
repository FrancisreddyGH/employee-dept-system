// EmployeeService.java
package com.example.employeemanagementsystem.Service;

import com.example.employeemanagementsystem.Dto.EmployeeDto;
import com.example.employeemanagementsystem.Entity.Employee;
import com.example.employeemanagementsystem.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        employee.setSalary(employeeDto.getSalary());
        employee.setDepartment(employeeDto.getDepartment());
        employeeRepository.save(employee);
        return employee;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getEmployeesWithDepartment() {
        return employeeRepository.getEmployeesWithDepartment();
    }

    public String updateEmployee(Long id, EmployeeDto employeeDto) {
        if (employeeRepository.existsById(id)) {
            Employee employee = employeeRepository.findById(id).get();
            employee.setName(employeeDto.getName());
            employee.setEmail(employeeDto.getEmail());
            employee.setSalary(employeeDto.getSalary());
            employee.setDepartment(employeeDto.getDepartment());
            employeeRepository.save(employee);
            return "employee has been updated";
        } else {
            return "couldn't find the employee with id " + id;
        }
    }

    public String deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return "employee has been deleted";
        } else {
            return "couldn't find the employee with id " + id;
        }
    }
}