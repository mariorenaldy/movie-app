package pro.luxen.movieapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pro.luxen.movieapp.model.Watchlist;
import pro.luxen.movieapp.service.WatchlistService;

import java.util.List;

@RestController
@RequestMapping("/api/watchlists")
public class WatchlistController {

    @Autowired
    private WatchlistService watchlistService;

    @GetMapping
    public List<Watchlist> getAllWatchlists() {
        return watchlistService.getAllWatchlists();
    }

    @PostMapping
    public Watchlist saveWatchlist(@RequestBody Watchlist watchlist) {
        return watchlistService.saveWatchlist(watchlist);
    }
}
