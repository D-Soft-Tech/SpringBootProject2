package com.adebayo.schoolManagement.department.utils;

import com.adebayo.schoolManagement.department.entity.Department;
import org.springframework.stereotype.Component;

@Component
public interface DepartmentUtils {
    Boolean doesDepartmentExists(Department departmentToCheck);

    Boolean doesDepartmentExists(Long departmentId);
}
