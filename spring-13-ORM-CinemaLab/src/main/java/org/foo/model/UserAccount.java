package org.foo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "user_account")
@NoArgsConstructor
@Data
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
    @OneToMany(mappedBy = "userAccount")
    private List<Ticket> tickets;
}
