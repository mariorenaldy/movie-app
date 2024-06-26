package pro.luxen.movieapp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
public class VideoResponse {
    private List<Video> results;

    @Getter
    @Setter
    public static class Video {
        private String id;
        private String key;
        private String name;
        private String site;
        private String type;
    }
}
