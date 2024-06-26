package pro.luxen.movieapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.luxen.movieapp.model.Movie;
import pro.luxen.movieapp.model.VideoResponse;

import java.util.List;
import java.util.Map;

@Service
public class MovieService {
    @Autowired
    private TmdbService tmdbService;

    public List<Movie> getPopularMovies(Map<String, String> params) {
        return tmdbService.getPopularMovies(params);
    }

    public Movie getMovieDetails(Long id) {
        return tmdbService.getMovieDetails(id);
    }

    public List<VideoResponse.Video> getMovieVideos(Long id) {
        return tmdbService.getMovieVideos(id);
    }
}
