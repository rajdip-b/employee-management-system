package com.ems.emsbackend.service;

import com.ems.emsbackend.entity.Employee;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    Employee getEmployeeById(String id);

    void deleteEmployee(String id);

}
