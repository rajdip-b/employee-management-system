package com.ems.emsbackend.service.impl;

import com.ems.emsbackend.entity.Employee;
import com.ems.emsbackend.repository.EmployeeRepository;
import com.ems.emsbackend.service.DepartmentService;
import com.ems.emsbackend.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentService departmentService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentService departmentService) {
        this.employeeRepository = employeeRepository;
        this.departmentService = departmentService;
    }

    @Override
    @Transactional
    public Employee createEmployee(Employee employee) {
        Employee e = new Employee();
        e.setName(employee.getName());
        e.setEmail(employee.getEmail());
        e.setPhone(employee.getPhone());
        e.setAddress(employee.getAddress());
        e.setDesignation(employee.getDesignation());
        e.setDepartment(departmentService.getDepartmentById(employee.getDepartment().getId()));
        return employeeRepository.save(e);
    }

    @Override
    @Transactional
    public Employee updateEmployee(Employee employee) {
        Employee e = getEmployeeById(employee.getId());
        e.setName(employee.getName() != null ? employee.getName() : e.getName());
        e.setEmail(employee.getEmail() != null ? employee.getEmail() : e.getEmail());
        e.setPhone(employee.getPhone() != null ? employee.getPhone() : e.getPhone());
        e.setAddress(employee.getAddress() != null ? employee.getAddress() : e.getAddress());
        e.setDesignation(employee.getDesignation() != null ? employee.getDesignation() : e.getDesignation());
        e.setDepartment(employee.getDepartment() != null ? departmentService.getDepartmentById(employee.getDepartment().getId()) : e.getDepartment());
        return employeeRepository.save(e);
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }
}
