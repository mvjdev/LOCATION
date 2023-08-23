package maria.hei.gestion_location.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Payment {
    private int id;
    private boolean paid;
    private String method;
    private int reservationId;
}
