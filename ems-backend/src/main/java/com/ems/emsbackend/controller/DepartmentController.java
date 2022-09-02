package com.ems.emsbackend.controller;

import com.ems.emsbackend.entity.Department;
import com.ems.emsbackend.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
@Slf4j
@CrossOrigin(origins = "*")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/")
    public ResponseEntity<?> createDepartment(@RequestBody Department department) {
        try {
            return ResponseEntity.status(201).body(departmentService.createDepartment(department));
        } catch (Exception e) {
            log.error("Error in creating department: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/")
    public ResponseEntity<?> updateDepartment(@RequestBody Department department) {
        try {
            return ResponseEntity.status(200).body(departmentService.updateDepartment(department));
        } catch (Exception e) {
            log.error("Error in updating department: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<?> deleteDepartment(@PathVariable String departmentId) {
        try {
            departmentService.deleteDepartment(departmentId);
            return ResponseEntity.status(200).build();
        } catch (Exception e) {
            log.error("Error in deleting department: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<?> getDepartment(@PathVariable String departmentId) {
        try {
            return ResponseEntity.status(200).body(departmentService.getDepartmentById(departmentId));
        } catch (Exception e) {
            log.error("Error in getting department: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllDepartments(
            @RequestParam(defaultValue = "", required = false, name = "name") String name) {
        try {
            if (name.equals(""))
                return ResponseEntity.status(200).body(departmentService.getAllDepartments());
            else
                return ResponseEntity.status(200).body(departmentService.getAllDepartmentsByName(name));
        } catch (Exception e) {
            log.error("Error in getting all departments: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{departmentId}/employees")
    public ResponseEntity<?> getAllEmployees(
            @PathVariable String departmentId,
            @RequestParam(defaultValue = "", required = false, name = "name") String name,
            @RequestParam(defaultValue = "0", required = false, name = "pageIndex") Integer pageIndex) {
        try {
            if (name == null)
                return ResponseEntity.status(200).body(departmentService.getAllEmployees(departmentId, pageIndex));
            else
                return ResponseEntity.status(200).body(departmentService.getAllEmployeesByName(departmentId, pageIndex, name));
        } catch (Exception e) {
            log.error("Error in getting all employees: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
