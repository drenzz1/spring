package org.foo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Employee {
    private String name ;
    private String department;
    private int hourlyRate;

}
