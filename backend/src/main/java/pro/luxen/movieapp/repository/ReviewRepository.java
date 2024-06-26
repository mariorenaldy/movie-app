package pro.luxen.movieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.luxen.movieapp.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
