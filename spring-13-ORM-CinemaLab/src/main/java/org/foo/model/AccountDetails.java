package org.foo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.foo.enums.Role;

@Entity
@Table(name = "account_details")
@Getter
@Setter
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
    private int age;
    private String postalCode;

    @Override
    public String toString() {
        return "AccountDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", age='" + age + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", role=" + role +
                '}';
    }

    @Enumerated(value = EnumType.STRING)
    private Role role ;
    @OneToOne(mappedBy = "accountDetails")
    private UserAccount userAccount;
}
