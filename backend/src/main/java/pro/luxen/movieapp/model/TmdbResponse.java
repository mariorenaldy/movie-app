package pro.luxen.movieapp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class TmdbResponse<T> {
    private int page;
    private List<T> results;
    private int total_pages;
    private int total_results;
}
