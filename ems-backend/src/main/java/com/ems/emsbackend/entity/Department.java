package com.ems.emsbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    public Department(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String name;
    private String description;
    @JsonIgnore
    @OneToMany(
            mappedBy = "department",
            cascade = CascadeType.ALL
    )
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        if (employees == null)
            employees = new ArrayList<>();
        return employees;
    }

}
