package com.ems.emsbackend.repository;

import com.ems.emsbackend.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String > {

    List<Department> findByNameContainingIgnoreCase(String name);

}
