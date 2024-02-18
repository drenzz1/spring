package org.foo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table(name = "departments")
@NoArgsConstructor
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String department;
    private String division;

    @OneToOne(mappedBy = "department")
    private Employee employee;

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
