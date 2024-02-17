package org.foo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity(name = "employee")
public class Employee {
    @Id()
    private Long id;
    private String name;


}
