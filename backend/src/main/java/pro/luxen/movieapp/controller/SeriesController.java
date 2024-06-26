package pro.luxen.movieapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pro.luxen.movieapp.model.Series;
import pro.luxen.movieapp.model.VideoResponse;
import pro.luxen.movieapp.service.SeriesService;
import pro.luxen.movieapp.service.TmdbService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/series")
public class SeriesController {

    @Autowired
    private SeriesService seriesService;
    @Autowired
    private TmdbService tmdbService;

    @GetMapping("/popular")
    public List<Series> getPopularSeries(@RequestParam Map<String, String> params) {
        return seriesService.getPopularSeries(params);
    }

    @GetMapping("/{id}")
    public Series getSeriesDetails(@PathVariable Long id) {
        return tmdbService.getSeriesDetails(id);
    }

    @GetMapping("/{id}/videos")
    public List<VideoResponse.Video> getSeriesVideos(@PathVariable Long id) {
        return tmdbService.getSeriesVideos(id);
    }
}
