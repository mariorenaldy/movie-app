package pro.luxen.movieapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.luxen.movieapp.model.Series;

import java.util.List;
import java.util.Map;

@Service
public class SeriesService {

    @Autowired
    private TmdbService tmdbService;

    public List<Series> getPopularSeries(Map<String, String> params) {
        return tmdbService.getPopularSeries(params);
    }
}
