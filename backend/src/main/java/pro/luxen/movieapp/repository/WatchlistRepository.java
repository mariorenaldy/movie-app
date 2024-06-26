package pro.luxen.movieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.luxen.movieapp.model.Watchlist;

public interface WatchlistRepository extends JpaRepository<Watchlist, Long> {
}
