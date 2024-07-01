package pro.luxen.movieapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pro.luxen.movieapp.model.*;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

@Service
public class TmdbService {

    @Value("${tmdb.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public TmdbResponse<Movie> getPopularMovies(Map<String, String> params) {
        String url = buildUrlWithParams("https://api.themoviedb.org/3/movie/popular", params);
        return restTemplate.getForObject(url, TmdbResponse.class);
    }

    public TmdbResponse<Movie> getTopRatedMovies(Map<String, String> params) {
        String url = buildUrlWithParams("https://api.themoviedb.org/3/movie/top_rated", params);
        return restTemplate.getForObject(url, TmdbResponse.class);
    }

    public TmdbResponse<Movie> getUpcomingMovies(Map<String, String> params) {
        String url = buildUrlWithParams("https://api.themoviedb.org/3/movie/upcoming", params);
        return restTemplate.getForObject(url, TmdbResponse.class);
    }

    public TmdbResponse<Movie> getMovieDetails(Long movieId) {
        String url = String.format("https://api.themoviedb.org/3/movie/%d?api_key=%s", movieId, apiKey);
        Movie movie = restTemplate.getForObject(url, Movie.class);

        TmdbResponse<Movie> response = new TmdbResponse<>();
        assert movie != null;
        response.setResults(List.of(movie));
        return response;
    }

    public TmdbResponse<VideoResponse.Video> getMovieVideos(Long movieId) {
        String url = String.format("https://api.themoviedb.org/3/movie/%d/videos?api_key=%s", movieId, apiKey);
        VideoResponse videoResponse = restTemplate.getForObject(url, VideoResponse.class);

        TmdbResponse<VideoResponse.Video> response = new TmdbResponse<>();
        assert videoResponse != null;
        response.setResults(videoResponse.getResults());
        return response;
    }

    public TmdbResponse<Movie> getSimilarMovies(Long movieId) {
        String url = String.format("https://api.themoviedb.org/3/movie/%d/similar?api_key=%s", movieId, apiKey);
        return restTemplate.getForObject(url, TmdbResponse.class);
    }

    public TmdbResponse<CreditResponse.Cast> getMovieCasts(Long movieId) {
        String url = String.format("https://api.themoviedb.org/3/movie/%d/credits?api_key=%s", movieId, apiKey);
        CreditResponse creditResponse = restTemplate.getForObject(url, CreditResponse.class);

        TmdbResponse<CreditResponse.Cast> response = new TmdbResponse<>();
        assert creditResponse != null;
        response.setResults(creditResponse.getCast());
        return response;
    }

    public TmdbResponse<Series> getPopularSeries(Map<String, String> params) {
        String url = buildUrlWithParams("https://api.themoviedb.org/3/tv/popular", params);
        return restTemplate.getForObject(url, TmdbResponse.class);
    }

    public TmdbResponse<Series> getTopRatedSeries(Map<String, String> params) {
        String url = buildUrlWithParams("https://api.themoviedb.org/3/tv/top_rated", params);
        return restTemplate.getForObject(url, TmdbResponse.class);
    }

    public TmdbResponse<Series> getSeriesDetails(Long seriesId) {
        String url = String.format("https://api.themoviedb.org/3/tv/%d?api_key=%s", seriesId, apiKey);
        Series series = restTemplate.getForObject(url, Series.class);

        TmdbResponse<Series> response = new TmdbResponse<>();
        response.setResults(List.of(series));
        return response;
    }

    public TmdbResponse<Series> getSimilarSeries(Long seriesId) {
        String url = String.format("https://api.themoviedb.org/3/tv/%d/similar?api_key=%s", seriesId, apiKey);
        return restTemplate.getForObject(url, TmdbResponse.class);
    }

    public TmdbResponse<CreditResponse.Cast> getSeriesCasts(Long seriesId) {
        String url = String.format("https://api.themoviedb.org/3/tv/%d/credits?api_key=%s", seriesId, apiKey);
        CreditResponse creditResponse = restTemplate.getForObject(url, CreditResponse.class);

        TmdbResponse<CreditResponse.Cast> response = new TmdbResponse<>();
        assert creditResponse != null;
        response.setResults(creditResponse.getCast());
        return response;
    }

    public TmdbResponse<VideoResponse.Video> getSeriesVideos(Long seriesId) {
        String url = String.format("https://api.themoviedb.org/3/tv/%d/videos?api_key=%s", seriesId, apiKey);
        VideoResponse videoResponse = restTemplate.getForObject(url, VideoResponse.class);

        TmdbResponse<VideoResponse.Video> response = new TmdbResponse<>();
        response.setResults(videoResponse.getResults());
        return response;
    }

    public TmdbResponse<Movie> searchMovies(Map<String, String> params) {
        String url = buildUrlWithParams("https://api.themoviedb.org/3/search/movie", params);
        return restTemplate.getForObject(url, TmdbResponse.class);
    }

    public TmdbResponse<Series> searchSeries(Map<String, String> params) {
        String url = buildUrlWithParams("https://api.themoviedb.org/3/search/tv", params);
        return restTemplate.getForObject(url, TmdbResponse.class);
    }

    private String buildUrlWithParams(String baseUrl, Map<String, String> params) {
        StringJoiner joiner = new StringJoiner("&");
        joiner.add("api_key=" + apiKey);
        for (Map.Entry<String, String> entry : params.entrySet()) {
            joiner.add(entry.getKey() + "=" + entry.getValue());
        }
        return baseUrl + "?" + joiner.toString();
    }
}
