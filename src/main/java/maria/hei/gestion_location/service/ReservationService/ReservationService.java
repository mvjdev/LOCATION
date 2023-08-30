package maria.hei.gestion_location.service.ReservationService;

import maria.hei.gestion_location.entity.Reservation;
import maria.hei.gestion_location.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ReservationService implements ReservationInterface{

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void
    createReservation(Reservation reservation) throws SQLException {
        reservationRepository.createReservation(reservation);
    }

    @Override
    public Reservation getReservationById(int id) throws SQLException {
        return reservationRepository.getReservationById(id);
    }

    @Override
    public List<Reservation> getAllReservations() throws SQLException {
        return reservationRepository.getAllReservations();
    }

    @Override
    public void updateReservation(Reservation reservation) throws SQLException {
        reservationRepository.updateReservation(reservation);
    }

    @Override
    public void deleteReservation(int id) throws SQLException {
        reservationRepository.deleteReservation(id);
    }
}
