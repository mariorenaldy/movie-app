package pro.luxen.movieapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pro.luxen.movieapp.model.CreditResponse;
import pro.luxen.movieapp.model.TmdbResponse;
import pro.luxen.movieapp.model.Movie;
import pro.luxen.movieapp.model.VideoResponse;
import pro.luxen.movieapp.service.MovieService;

import java.util.Map;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/popular")
    public TmdbResponse<Movie> getPopularMovies(@RequestParam Map<String, String> params) {
        return movieService.getPopularMovies(params);
    }

    @GetMapping("/top_rated")
    public TmdbResponse<Movie> getTopRatedMovies(@RequestParam Map<String, String> params) {
        return movieService.getTopRatedMovies(params);
    }

    @GetMapping("/upcoming")
    public TmdbResponse<Movie> getUpcomingMovies(@RequestParam Map<String, String> params) {
        return movieService.getUpcomingMovies(params);
    }

    @GetMapping("/{id}")
    public TmdbResponse<Movie> getMovieDetails(@PathVariable Long id) {
        return movieService.getMovieDetails(id);
    }

    @GetMapping("/{id}/videos")
    public TmdbResponse<VideoResponse.Video> getMovieVideos(@PathVariable Long id) {
        return movieService.getMovieVideos(id);
    }

    @GetMapping("/{id}/similar")
    public TmdbResponse<Movie> getSimilarMovies(@PathVariable Long id) {
        return movieService.getSimilarMovies(id);
    }

    @GetMapping("/{id}/credits")
    public TmdbResponse<CreditResponse.Cast> getMovieCasts(@PathVariable Long id) {
        return movieService.getMovieCasts(id);
    }

    @GetMapping("/search")
    public TmdbResponse<Movie> searchMovies(@RequestParam Map<String, String> params) {
        return movieService.searchMovies(params);
    }
}
