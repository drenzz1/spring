package org.foo.model;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie ;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalTime dateTime;
    @OneToMany(mappedBy = "movieCinema")
    private List<Ticket> tickets;

    @Override
    public String toString() {
        return "MovieCinema{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", tickets=" + tickets +
                '}';
    }
}
