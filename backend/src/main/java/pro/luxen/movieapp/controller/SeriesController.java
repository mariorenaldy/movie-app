package pro.luxen.movieapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pro.luxen.movieapp.model.*;
import pro.luxen.movieapp.service.SeriesService;

import java.util.Map;

@RestController
@RequestMapping("/api/series")
public class SeriesController {
    @Autowired
    private SeriesService seriesService;

    @GetMapping("/popular")
    public TmdbResponse<Series> getPopularSeries(@RequestParam Map<String, String> params) {
        return seriesService.getPopularSeries(params);
    }

    @GetMapping("/top_rated")
    public TmdbResponse<Series> getTopRatedSeries(@RequestParam Map<String, String> params) {
        return seriesService.getTopRatedSeries(params);
    }

    @GetMapping("/{id}")
    public TmdbResponse<Series> getSeriesDetails(@PathVariable Long id) {
        return seriesService.getSeriesDetails(id);
    }

    @GetMapping("/{id}/videos")
    public TmdbResponse<VideoResponse.Video> getSeriesVideos(@PathVariable Long id) {
        return seriesService.getSeriesVideos(id);
    }

    @GetMapping("/{id}/similar")
    public TmdbResponse<Series> getSimilarSeries(@PathVariable Long id) {
        return seriesService.getSimilarSeries(id);
    }

    @GetMapping("/{id}/credits")
    public TmdbResponse<CreditResponse.Cast> getSeriesCasts(@PathVariable Long id) {
        return seriesService.getSeriesCasts(id);
    }

    @GetMapping("/search")
    public TmdbResponse<Series> searchSeries(@RequestParam Map<String, String> params) {
        return seriesService.searchSeries(params);
    }
}
