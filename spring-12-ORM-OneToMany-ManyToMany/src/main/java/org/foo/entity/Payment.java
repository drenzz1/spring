package org.foo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.foo.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DATE")
    private LocalDate createdDate;

    private BigDecimal amount;
    @Enumerated(value = EnumType.STRING)
    private Status paymentStatus;


    @OneToOne(cascade = CascadeType.ALL) // nrastet kur te boj cascade all nuk kom nevoj me kriju repositorin e klases payment detials
    private PaymentDetail paymentDetail;

    @ManyToOne
    private Merchant merchant;
    @ManyToOne
    private Customer customer;

    public Payment(LocalDate createdDate, BigDecimal amount, Status paymentStatus) {
        this.createdDate = createdDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }
}
