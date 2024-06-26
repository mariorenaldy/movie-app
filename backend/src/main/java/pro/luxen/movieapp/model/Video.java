package pro.luxen.movieapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Video {
    @Id
    private Long id;

    private String key;
}
