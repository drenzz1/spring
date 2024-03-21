package org.foo.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
@Entity
public class CreditAccount extends Account{
    BigDecimal creditLimit;

    public CreditAccount() {

    }

    public CreditAccount(Long id, String owner, BigDecimal balance, BigDecimal interestRate, BigDecimal creditLimit) {
        super(id, owner, balance, interestRate);
        this.creditLimit = creditLimit;
    }
}
