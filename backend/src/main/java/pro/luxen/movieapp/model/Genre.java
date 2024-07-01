package pro.luxen.movieapp.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Genre {
    private Long id;
    private String name;
}
