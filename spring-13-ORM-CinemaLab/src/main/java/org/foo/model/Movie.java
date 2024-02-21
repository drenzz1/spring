package org.foo.model;

import jakarta.persistence.*;
import jdk.jfr.MemoryAddress;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.foo.enums.State;
import org.foo.enums.Type;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "movie")
@NoArgsConstructor
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    @OneToMany(mappedBy = "movie")
    private List<MovieCinema> movieCinema;
    @Enumerated(value = EnumType.STRING)
    private Type type;
    @Enumerated(value = EnumType.STRING)
    private State state;
    @Column(name = "release_date")
    private LocalDate localDate;
    private BigDecimal duration;
    private String summary;
    @ManyToMany(mappedBy = "movies")
    private List<Genre> genres;
}
