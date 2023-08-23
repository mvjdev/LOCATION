package maria.hei.gestion_location.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Offers {
    private int id;
    private String varchar;
    private int number_of_room;
    private boolean toilet_intern;
    private boolean bathroom;
    private float price;
    private boolean is_active;
}
