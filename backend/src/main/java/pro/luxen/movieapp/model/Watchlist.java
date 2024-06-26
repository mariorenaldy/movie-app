package pro.luxen.movieapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Watchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    private Boolean watched;
}
