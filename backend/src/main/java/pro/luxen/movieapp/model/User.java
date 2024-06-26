package pro.luxen.movieapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    private String email;
}
