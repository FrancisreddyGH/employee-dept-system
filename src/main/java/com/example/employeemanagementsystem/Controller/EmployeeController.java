// EmployeeController.java
package com.example.employeemanagementsystem.Controller;

import com.example.employeemanagementsystem.Dto.EmployeeDto;
import com.example.employeemanagementsystem.Entity.Employee;
import com.example.employeemanagementsystem.Service.EmployeeService;
import com.example.employeemanagementsystem.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        model.addAttribute("departments", departmentService.getDepartments());
        return "employee_add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute EmployeeDto employeeDto) {
        employeeService.createEmployee(employeeDto);
        return "redirect:/employee/getall";
    }

    @GetMapping("/getall")
    public String getAll(Model model) {
        model.addAttribute("employees", employeeService.getEmployeesWithDepartment());
        return "employee_getall";
    }

    @GetMapping("/getbyid/{id}")
    public String getById(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee_getbyid";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        EmployeeDto dto = new EmployeeDto();
        dto.setName(employee.getName());
        dto.setEmail(employee.getEmail());
        dto.setSalary(employee.getSalary());
        dto.setDepartment(employee.getDepartment());
        model.addAttribute("employeeDto", dto);
        model.addAttribute("employeeId", id);
        model.addAttribute("departments", departmentService.getDepartments());
        return "employee_edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute EmployeeDto employeeDto) {
        employeeService.updateEmployee(id, employeeDto);
        return "redirect:/employee/getall";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee/getall";
    }
}