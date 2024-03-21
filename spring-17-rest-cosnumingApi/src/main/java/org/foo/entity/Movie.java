package org.foo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.foo.enums.State;
import org.foo.enums.Type;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "movie")
@NoArgsConstructor
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    @Enumerated(value = EnumType.STRING)
    private Type type;
    @Enumerated(value = EnumType.STRING)
    private State state;
    @Column(name = "release_date",columnDefinition = "DATE")
    private LocalDate localDate;
    private Integer duration;
    @Column(columnDefinition = "text")
    private String summary;
    @ManyToMany(mappedBy = "movies")
    private List<Genre> genres;

}
