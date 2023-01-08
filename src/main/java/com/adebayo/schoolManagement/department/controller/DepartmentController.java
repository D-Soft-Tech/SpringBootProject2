package com.adebayo.schoolManagement.department.controller;

import com.adebayo.schoolManagement.department.entity.Department;
import com.adebayo.schoolManagement.department.service.DepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/departments/{departmentId}")
    public Department getDepartmentById(@PathVariable("departmentId") Long departmentId) {
        LOGGER.info("Department Id passed is: '" + departmentId + "'");
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{departmentId}")
    public String deleteDepartment(@PathVariable("departmentId") Long departmentId) {
        return departmentService.deleteDepartment(departmentId);
    }

    @PutMapping("/departments/{departmentId}")
    public Department updateDepartment(@PathVariable("departmentId") Long departmentId, @Valid @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId, department);
    }
}
