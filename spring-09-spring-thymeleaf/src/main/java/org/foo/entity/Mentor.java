package org.foo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Mentor {
    private String firstName;
    private String lastName;
    private String email;
    private Gender Gender;
    private String batch;
    private boolean graduated;
    private String company;
}
enum Gender{
    MALE,FEMALE
}
