package org.foo.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
@Entity
public class DebitAccount extends Account{
    private BigDecimal overDraftFee;

    public DebitAccount(Long id, String owner, BigDecimal balance, BigDecimal interestRate, BigDecimal overDraftFee) {
        super(id, owner, balance, interestRate);
        this.overDraftFee = overDraftFee;
    }

    public DebitAccount() {
    }
}
