package maria.hei.gestion_location.entity;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor(force = true)
public class User {
    private long id;
    private String name;
    private String email;
    private String password;

    public User(int id, String name, String email, String password) {
    }
}

