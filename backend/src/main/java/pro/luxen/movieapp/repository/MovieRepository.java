package pro.luxen.movieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.luxen.movieapp.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
