package maria.hei.gestion_location.entity;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Reservation {
    private int id;
    private Date startDate;
    private Date endDate;
    private int userId;
}


