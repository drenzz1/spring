package org.foo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "movie_cinema")
@Getter
@Setter
@NoArgsConstructor
public class MovieCinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie ;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;


    @Column(columnDefinition = "TIMESTAMP")
    private LocalTime dateTime;

}
