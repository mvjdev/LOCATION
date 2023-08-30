package maria.hei.gestion_location.service.ReservationService;

import maria.hei.gestion_location.entity.Reservation;

import java.sql.SQLException;
import java.util.List;

public interface ReservationInterface {
    void createReservation(Reservation reservation) throws SQLException;
    Reservation getReservationById(int id) throws SQLException;
    List<Reservation> getAllReservations() throws SQLException;
    void updateReservation(Reservation reservation) throws SQLException;
    void deleteReservation(int id) throws SQLException;
}
