package org.foo.model;

import jakarta.persistence.*;
import org.foo.enums.Gender;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "studentFirstName")
    private String firstName;
    @Column(name = "studentLastName")
    private String lastName;
    private String email;
    @Transient//nuk e krijon si attribut ne databaz
    private String city;
    @Column(columnDefinition = "DATE")
    private LocalDate birthdate;
    @Column(columnDefinition = "TIME")
    private LocalTime birthTime;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate birthDateTime;
    @Enumerated(EnumType.STRING)
    private Gender gender;

}
