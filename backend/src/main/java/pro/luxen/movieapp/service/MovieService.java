package pro.luxen.movieapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.luxen.movieapp.model.*;

import java.util.Map;

@Service
public class MovieService {
    @Autowired
    private TmdbService tmdbService;

    public TmdbResponse<Movie> getPopularMovies(Map<String, String> params) {
        return tmdbService.getPopularMovies(params);
    }

    public TmdbResponse<Movie> getTopRatedMovies(Map<String, String> params) {
        return tmdbService.getTopRatedMovies(params);
    }

    public TmdbResponse<Movie> getUpcomingMovies(Map<String, String> params) {
        return tmdbService.getUpcomingMovies(params);
    }

    public TmdbResponse<Movie> getMovieDetails(Long id) {
        return tmdbService.getMovieDetails(id);
    }

    public TmdbResponse<VideoResponse.Video> getMovieVideos(Long id) {
        return tmdbService.getMovieVideos(id);
    }

    public TmdbResponse<Movie> getSimilarMovies(Long id) {
        return tmdbService.getSimilarMovies(id);
    }

    public TmdbResponse<CreditResponse.Cast> getMovieCasts(Long id) {
        return tmdbService.getMovieCasts(id);
    }

    public TmdbResponse<Movie> searchMovies(Map<String, String> params) {
        return tmdbService.searchMovies(params);
    }
}
