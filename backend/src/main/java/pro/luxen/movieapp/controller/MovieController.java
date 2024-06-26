package pro.luxen.movieapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pro.luxen.movieapp.model.Movie;
import pro.luxen.movieapp.model.VideoResponse;
import pro.luxen.movieapp.service.MovieService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/popular")
    public List<Movie> getPopularMovies(@RequestParam Map<String, String> params) {
        return movieService.getPopularMovies(params);
    }

    @GetMapping("/{id}")
    public Movie getMovieDetails(@PathVariable Long id) {
        return movieService.getMovieDetails(id);
    }

    @GetMapping("/{id}/videos")
    public List<VideoResponse.Video> getMovieVideos(@PathVariable Long id) {
        return movieService.getMovieVideos(id);
    }
}
