package pro.luxen.movieapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pro.luxen.movieapp.model.Movie;
import pro.luxen.movieapp.model.TmdbResponse;
import pro.luxen.movieapp.model.VideoResponse;
import pro.luxen.movieapp.model.Series;
import pro.luxen.movieapp.model.SeriesResponse;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

@Service
public class TmdbService {

    @Value("${tmdb.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Movie> getPopularMovies(Map<String, String> params) {
        String url = buildUrlWithParams("https://api.themoviedb.org/3/movie/popular", params);
        TmdbResponse response = restTemplate.getForObject(url, TmdbResponse.class);
        return response.getResults();
    }

    public Movie getMovieDetails(Long movieId) {
        String url = String.format("https://api.themoviedb.org/3/movie/%d?api_key=%s", movieId, apiKey);
        return restTemplate.getForObject(url, Movie.class);
    }

    public List<VideoResponse.Video> getMovieVideos(Long movieId) {
        String url = String.format("https://api.themoviedb.org/3/movie/%d/videos?api_key=%s", movieId, apiKey);
        VideoResponse response = restTemplate.getForObject(url, VideoResponse.class);
        return response.getResults();
    }

    public List<Series> getPopularSeries(Map<String, String> params) {
        String url = buildUrlWithParams("https://api.themoviedb.org/3/tv/popular", params);
        SeriesResponse response = restTemplate.getForObject(url, SeriesResponse.class);
        return response.getResults();
    }

    public Series getSeriesDetails(Long seriesId) {
        String url = String.format("https://api.themoviedb.org/3/tv/%d?api_key=%s", seriesId, apiKey);
        return restTemplate.getForObject(url, Series.class);
    }

    public List<VideoResponse.Video> getSeriesVideos(Long seriesId) {
        String url = String.format("https://api.themoviedb.org/3/tv/%d/videos?api_key=%s", seriesId, apiKey);
        VideoResponse response = restTemplate.getForObject(url, VideoResponse.class);
        return response.getResults();
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
