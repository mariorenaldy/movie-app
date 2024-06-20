package pro.luxen.movieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.luxen.movieapp.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}