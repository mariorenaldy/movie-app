package pro.luxen.movieapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Movie {
    @Id
    private Long id;

    private String title;

    @JsonProperty("original_title")
    private String originalTitle;

    private String overview;

    @JsonProperty("release_date")
    private String releaseDate;

    private double popularity;

    @JsonProperty("poster_path")
    private String posterPath;

    @JsonProperty("vote_average")
    private double voteAverage;

    @JsonProperty("vote_count")
    private int voteCount;
}
