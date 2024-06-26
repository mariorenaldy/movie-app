package pro.luxen.movieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.luxen.movieapp.model.Series;

public interface SeriesRepository extends JpaRepository<Series, Long> {
}
