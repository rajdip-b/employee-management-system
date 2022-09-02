package com.ems.emsbackend.service;

import com.ems.emsbackend.entity.Department;
import com.ems.emsbackend.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartments();

    Department getDepartmentById(String id);

    Department createDepartment(Department department);

    Department updateDepartment(Department department);

    void deleteDepartment(String id);

    List<Department> getAllDepartmentsByName(String name);

    Page<Employee> getAllEmployees(String departmentId, Integer pageIndex);

    Page<Employee> getAllEmployeesByName(String departmentId, Integer pageIndex, String name);

}
