package org.foo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "departments")
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)
    private String department;
    private String division;
}
