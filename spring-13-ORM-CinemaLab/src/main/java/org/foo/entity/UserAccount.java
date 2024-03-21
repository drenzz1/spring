package org.foo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "user_account")
@NoArgsConstructor
@Getter
@Setter
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String username;
    @OneToOne
    @JoinColumn(name = "account_details_id")
    private AccountDetails accountDetails;
    @OneToMany(mappedBy = "userAccount", fetch = FetchType.EAGER)
    private List<Ticket> tickets;


    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", tickets=" + tickets +
                '}';
    }
}
