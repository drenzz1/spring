package org.foo.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
@MappedSuperclass
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;
    private BigDecimal balance;
    private BigDecimal interestRate;

    public Account(Long id, String owner, BigDecimal balance, BigDecimal interestRate) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public Account() {
    }
}
