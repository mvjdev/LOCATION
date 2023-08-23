package maria.hei.gestion_location.service;

import maria.hei.gestion_location.entity.Reservation;
import maria.hei.gestion_location.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PayementService {

    private ReservationRepository reservationRepository;

    public PayementService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void createReservation(Reservation reservation) throws SQLException {
        // Implement any validation or business logic before creating the reservation
        reservationRepository.createReservation(reservation);
    }

    public Reservation getReservationById(int reservationId) throws SQLException {
        // Implement any additional logic before fetching the reservation
        return reservationRepository.getReservationById(reservationId);
    }

    public List<Reservation> getAllReservations() throws SQLException {
        // Implement any logic before fetching all reservations
        return reservationRepository.getAllReservations();
    }

    public void updateReservation(Reservation reservation) throws SQLException {
        // Implement any validation or logic before updating the reservation
        reservationRepository.updateReservation(reservation);
    }

    public void deleteReservation(int reservationId) throws SQLException {
        // Implement any logic before deleting the reservation
        reservationRepository.deleteReservation(reservationId);
    }
}

