// DepartmentController.java
package com.example.employeemanagementsystem.Controller;

import com.example.employeemanagementsystem.Dto.DepartmentDto;
import com.example.employeemanagementsystem.Entity.Department;
import com.example.employeemanagementsystem.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("departmentDto", new DepartmentDto());
        return "department_add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute DepartmentDto departmentDto) {
        departmentService.createDepartment(departmentDto);
        return "redirect:/department/getall";
    }

    @GetMapping("/getall")
    public String getAll(Model model) {
        model.addAttribute("departments", departmentService.getDepartments());
        return "department_getall";
    }

    @GetMapping("/getbyid/{id}")
    public String getById(@PathVariable Long id, Model model) {
        Department department = departmentService.getDepartmentById(id);
        model.addAttribute("department", department);
        return "department_getbyid";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Department department = departmentService.getDepartmentById(id);
        model.addAttribute("departmentDto", department);
        model.addAttribute("departmentId", id);
        return "department_edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute DepartmentDto departmentDto) {
        departmentService.updateDepartment(id, departmentDto);
        return "redirect:/department/getall";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return "redirect:/department/getall";
    }
}