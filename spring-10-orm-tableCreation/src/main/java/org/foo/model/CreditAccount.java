package org.foo.model;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
@Entity
public class CreditAccount extends Account{
    BigDecimal creditLimit;

}
