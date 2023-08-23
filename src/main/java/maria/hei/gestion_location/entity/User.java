package maria.hei.gestion_location.entity;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class User {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String role;
}

