package org.foo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.foo.enums.Gender;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@Data
public class Employee {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @Column(columnDefinition = "DATE")
    private LocalDateTime hireDate;
    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
    private BigDecimal salary;
    @ManyToOne
    private Region region;

}
