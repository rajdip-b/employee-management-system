package com.ems.emsbackend.controller;

import com.ems.emsbackend.entity.Employee;
import com.ems.emsbackend.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
@Slf4j
@CrossOrigin(origins = "*")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        try {
            return ResponseEntity.status(201).body(employeeService.createEmployee(employee));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error creating employee: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
        try {
            return ResponseEntity.status(200).body(employeeService.updateEmployee(employee));
        } catch (Exception e) {
            log.error("Error updating employee: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<?> getEmployeeById(@PathVariable String employeeId) {
        try {
            return ResponseEntity.status(200).body(employeeService.getEmployeeById(employeeId));
        } catch (Exception e) {
            log.error("Error getting employee: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String employeeId) {
        try {
            employeeService.deleteEmployee(employeeId);
            return ResponseEntity.status(200).body("Employee deleted successfully");
        } catch (Exception e) {
            log.error("Error deleting employee: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
