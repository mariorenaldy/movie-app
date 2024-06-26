package pro.luxen.movieapp.model;

import java.util.List;

public class SeriesResponse {
    private List<Series> results;

    public List<Series> getResults() {
        return results;
    }

    public void setResults(List<Series> results) {
        this.results = results;
    }
}
