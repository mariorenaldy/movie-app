package pro.luxen.movieapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.luxen.movieapp.model.*;

import java.util.Map;

@Service
public class SeriesService {
    @Autowired
    private TmdbService tmdbService;

    public TmdbResponse<Series> getPopularSeries(Map<String, String> params) {
        return tmdbService.getPopularSeries(params);
    }

    public TmdbResponse<Series> getTopRatedSeries(Map<String, String> params) {
        return tmdbService.getTopRatedSeries(params);
    }

    public TmdbResponse<Series> getSeriesDetails(Long id) {
        return tmdbService.getSeriesDetails(id);
    }

    public TmdbResponse<VideoResponse.Video> getSeriesVideos(Long id) {
        return tmdbService.getSeriesVideos(id);
    }

    public TmdbResponse<Series> getSimilarSeries(Long id) {
        return tmdbService.getSimilarSeries(id);
    }

    public TmdbResponse<CreditResponse.Cast> getSeriesCasts(Long id) {
        return tmdbService.getSeriesCasts(id);
    }

    public TmdbResponse<Series> searchSeries(Map<String, String> params) {
        return tmdbService.searchSeries(params);
    }
}
