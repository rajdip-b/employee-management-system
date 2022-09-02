package com.ems.emsbackend.service.impl;

import com.ems.emsbackend.entity.Department;
import com.ems.emsbackend.entity.Employee;
import com.ems.emsbackend.repository.DepartmentRepository;
import com.ems.emsbackend.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(String id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Department createDepartment(Department department) {
        Department d = new Department();
        d.setDescription(department.getDescription());
        d.setName(department.getName());
        return departmentRepository.save(d);
    }

    @Override
    @Transactional
    public Department updateDepartment(Department department) {
        Department d = departmentRepository.findById(department.getId()).orElse(null);
        if (d == null)
            return null;
        d.setDescription(department.getDescription() != null ? department.getDescription() : d.getDescription());
        d.setName(department.getName() != null ? department.getName() : d.getName());
        return departmentRepository.save(d);
    }

    @Override
    @Transactional
    public void deleteDepartment(String id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public List<Department> getAllDepartmentsByName(String name) {
        return departmentRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Page<Employee> getAllEmployees(String departmentId, Integer pageIndex) {
        pageIndex = pageIndex >= 0 ? pageIndex : 0;
        var employees = getDepartmentById(departmentId).getEmployees();

        return new PageImpl<>(
                employees,
                PageRequest.of(pageIndex, 10, Sort.Direction.ASC, "name"),
                employees.size()
        );
    }

    @Override
    public Page<Employee> getAllEmployeesByName(String departmentId, Integer pageIndex, String name) {
        pageIndex = pageIndex >= 0 ? pageIndex : 0;
        var employees = getDepartmentById(departmentId).getEmployees();
        employees = employees.stream().filter(e -> e.getName().toLowerCase().contains(name.toLowerCase())).toList();

        return new PageImpl<>(
                employees,
                PageRequest.of(pageIndex, 10, Sort.Direction.ASC, "name"),
                employees.size()
        );
    }

    @Bean
    @Transactional
    public void createDummyDepartments() {
        var departments = List.of(
                new Department("IT", "IT Manager"),
                new Department("HR", "HR Manager"),
                new Department("Finance", "Finance Manager"),
                new Department("Sales", "Sales Manager"),
                new Department("Marketing", "Marketing Manager"),
                new Department("Operations", "Operations Manager"),
                new Department("Admin", "Admin Manager"),
                new Department("Legal", "Legal Manager"),
                new Department("R&D", "R&D Manager"),
                new Department("Customer Support", "Customer Support Manager"),
                new Department("Business Development", "Business Development Manager"),
                new Department("Product Development", "Product Development Manager"),
                new Department("Quality Assurance", "Quality Assurance Manager"),
                new Department("Supply Chain", "Supply Chain Manager"),
                new Department("Logistics", "Logistics Manager"),
                new Department("Procurement", "Procurement Manager"),
                new Department("Research", "Research Manager"),
                new Department("Training", "Training Manager"),
                new Department("Health & Safety", "Health & Safety Manager"),
                new Department("Engineering", "Engineering Manager")
        );
        departmentRepository.saveAll(departments);
    }
}
