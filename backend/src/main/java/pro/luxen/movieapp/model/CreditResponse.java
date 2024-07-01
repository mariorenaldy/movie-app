package pro.luxen.movieapp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreditResponse {
    private List<Cast> cast;
    private List<Crew> crew;

    @Getter
    @Setter
    public static class Cast {
        private Long id;
        private String name;
        private String character;
        private String profile_path;
    }

    @Getter
    @Setter
    public static class Crew {
        private Long id;
        private String name;
        private String department;
        private String job;
        private String profile_path;
    }
}
