package org.foo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.foo.enums.Gender;
import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    private Integer  salary;
    @OneToOne(cascade = CascadeType.ALL)
//    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee(String firstName, String lastName, String email, LocalDate hireDate, Gender gender, Integer salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hireDate = hireDate;
        this.gender = gender;
        this.salary = salary;
    }
}
