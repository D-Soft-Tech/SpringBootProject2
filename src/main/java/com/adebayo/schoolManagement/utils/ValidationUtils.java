package com.adebayo.schoolManagement.utils;

import com.adebayo.schoolManagement.department.entity.Department;
import org.springframework.stereotype.Component;

@Component
public interface ValidationUtils {
    Boolean isParameterNotEmptyAndLongEnough(String param);
    void  validate(Department department);
}
