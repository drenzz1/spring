package org.foo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

@Entity
@Table(name = "account_details")
@Data
@NoArgsConstructor
public class AccountDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String country;
    private String city;
    private String state;
    private String age;
    private String postalCode;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @OneToOne(mappedBy = "accountDetails")
    private UserAccount userAccount;
}
enum Role{
    ADMIN,USER
}