package com.adebayo.schoolManagement.utils;

import com.adebayo.schoolManagement.department.entity.Department;
import org.springframework.stereotype.Component;

import java.security.InvalidParameterException;

@Component
public class ValidationUtilsImpl implements ValidationUtils {
    @Override
    public Boolean isParameterNotEmptyAndLongEnough(String param) {
        if (param.length() >= 3) {
            return true;
        } else {
            throw new InvalidParameterException("Supplied parameter " + param + " is too short");
        }
    }

    @Override
    public void validate(Department department) {
        if (department.getDepartmentId() < 0) {
            throw new IllegalStateException("Invalid Id " + department.getDepartmentId());
        }
        if (department.getDepartmentCode().length() < 5) {
            throw new IllegalStateException("Supplied department code " + department.getDepartmentCode() + " is valid, Department code can not be less than 5 characters");
        }
        if (department.getDepartmentName().length() < 3) {

            throw new IllegalStateException("Supplied department name " + department.getDepartmentName() + " is valid, Department name can not be less than 3 characters");
        }
        if (department.getDepartmentAddress().length() < 10) {
            throw new IllegalStateException("Supplied department address " + department.getDepartmentAddress() + " is valid, Department address can not be less than 10 characters");
        }
    }
}
