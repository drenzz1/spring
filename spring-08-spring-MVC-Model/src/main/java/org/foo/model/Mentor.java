package org.foo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.foo.enums.Gender;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mentor {
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;


}
