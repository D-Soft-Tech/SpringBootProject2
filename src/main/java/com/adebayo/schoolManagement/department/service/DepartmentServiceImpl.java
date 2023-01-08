package com.adebayo.schoolManagement.department.service;

import com.adebayo.schoolManagement.department.entity.Department;
import com.adebayo.schoolManagement.department.repository.DepartmentRepository;
import com.adebayo.schoolManagement.department.utils.DepartmentUtilsImpl;
import com.adebayo.schoolManagement.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DepartmentUtilsImpl departmentUtils;
    @Autowired
    private ValidationUtils validationUtils;

    @Override
    public Department addDepartment(Department department) {
        Optional<Department> departmentChecker = departmentRepository.findDepartmentByDepartmentCode(department.getDepartmentCode());
        if (departmentChecker.isPresent()) {
            throw new IllegalStateException("Department with Department code " + department.getDepartmentCode() + " already exist");
        } else {
            return departmentRepository.save(department);
        }
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        if (departmentUtils.doesDepartmentExists(departmentId)) {
            return departmentRepository.findById(departmentId).get();
        } else {
            throw new IllegalStateException("No department with the id: " + departmentId + " exists");
        }
    }

    @Override
    public String deleteDepartment(Long departmentId) {
        if (departmentUtils.doesDepartmentExists(departmentId)) {
            departmentRepository.deleteById(departmentId);
            return "Department with department id: " + departmentId + " has been deleted successfully";
        } else {
            return "Department with id: " + departmentId + " does not exist";
        }
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        validationUtils.validate(department);
        if (departmentUtils.doesDepartmentExists(departmentId)) {
            Department departmentFound = departmentRepository.findById(departmentId).get();
            departmentFound.setDepartmentCode(department.getDepartmentCode());
            departmentFound.setDepartmentAddress(department.getDepartmentAddress());
            departmentFound.setDepartmentName(department.getDepartmentName());
            return addDepartment(departmentFound);
        } else {
            throw new IllegalStateException("Something went wrong!!!");
        }
    }
}
