package pro.luxen.movieapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 5000)
    private String overview;
}