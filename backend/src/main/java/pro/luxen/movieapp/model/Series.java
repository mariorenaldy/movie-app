package pro.luxen.movieapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Series {
    @Id
    private Long id;

    private String name;

    private String overview;

    @JsonProperty("first_air_date")
    private String firstAirDate;

    private double popularity;

    @JsonProperty("poster_path")
    private String posterPath;

    @JsonProperty("vote_average")
    private double voteAverage;

    @JsonProperty("vote_count")
    private int voteCount;
}
