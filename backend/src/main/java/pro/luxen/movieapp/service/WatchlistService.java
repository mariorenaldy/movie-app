package pro.luxen.movieapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.luxen.movieapp.model.Watchlist;
import pro.luxen.movieapp.repository.WatchlistRepository;

import java.util.List;

@Service
public class WatchlistService {

    @Autowired
    private WatchlistRepository watchlistRepository;

    public List<Watchlist> getAllWatchlists() {
        return watchlistRepository.findAll();
    }

    public Watchlist saveWatchlist(Watchlist watchlist) {
        return watchlistRepository.save(watchlist);
    }
}

