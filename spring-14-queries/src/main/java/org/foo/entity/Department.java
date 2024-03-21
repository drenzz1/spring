package org.foo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "departments")
@NoArgsConstructor
public class Department {
    @Id
    private String department;
    private String division;
}
