package pro.luxen.movieapp.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Series {
    @Id
    private Long id;
    private String name;
    private String overview;
    private String first_air_date;
    private double popularity;
    private String poster_path;
    private double vote_average;
    private int vote_count;

    @ElementCollection
    private List<Genre> genres;
}
