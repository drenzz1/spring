package org.foo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
@Data
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private MovieCinema movieCinema;
    @ManyToOne
    private UserAccount userAccount;
    @Column(name = "date_time")
    private LocalDateTime localDateTime;
    private int seatNumber;
    private int rowNumber;
}