package pro.luxen.movieapp.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Movie {
    @Id
    private Long id;
    private String title;
    private String original_title;
    private String overview;
    private String release_date;
    private double popularity;
    private String poster_path;
    private String backdrop_path;
    private double vote_average;
    private int vote_count;

    @ElementCollection
    private List<Genre> genres;
}
