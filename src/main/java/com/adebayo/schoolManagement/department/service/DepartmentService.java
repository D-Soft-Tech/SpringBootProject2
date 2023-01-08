package com.adebayo.schoolManagement.department.service;

import com.adebayo.schoolManagement.department.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    Department addDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(Long departmentId);

    String deleteDepartment(Long departmentId);

    Department updateDepartment(Long depatmentId, Department department);
}
