package org.foo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
@Entity
public class DebitAccount extends Account{
    private BigDecimal overDraftFee;
}
