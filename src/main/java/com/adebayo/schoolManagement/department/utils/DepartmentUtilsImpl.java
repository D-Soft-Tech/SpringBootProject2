package com.adebayo.schoolManagement.department.utils;

import com.adebayo.schoolManagement.department.entity.Department;
import com.adebayo.schoolManagement.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DepartmentUtilsImpl implements DepartmentUtils{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Boolean doesDepartmentExists(Department department) {
        Optional<Department> departmentExists = departmentRepository.findDepartmentByDepartmentCode(department.getDepartmentCode());
        if(departmentExists.isPresent()) {
            throw new IllegalArgumentException("A department with department code "+ department.getDepartmentCode() + " already exists");
        }
        return false;
    }

    @Override
    public Boolean doesDepartmentExists(Long departmentId) {
        Optional<Department> departmentExists = departmentRepository.findById(departmentId);
        return departmentExists.isPresent();
    }
}
