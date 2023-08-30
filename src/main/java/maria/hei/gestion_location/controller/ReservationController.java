package maria.hei.gestion_location.controller;

import maria.hei.gestion_location.entity.Reservation;
import maria.hei.gestion_location.repository.ReservationRepository;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private PayementService reservationService = new PayementService(new ReservationRepository());

    public ReservationController() throws SQLException {
    }

    @PostMapping
    public void createReservation(@RequestBody Reservation reservation) throws SQLException {
        reservationService.createReservation(reservation);
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable("id") int reservationId) throws SQLException {
        return reservationService.getReservationById(reservationId);
    }

    @GetMapping
    public List<Reservation> getAllReservations() throws SQLException {
        return reservationService.getAllReservations();
    }

    @PutMapping
    public void updateReservation(@RequestBody Reservation reservation) throws SQLException {
        reservationService.updateReservation(reservation);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable("id") int reservationId) throws SQLException {
        reservationService.deleteReservation(reservationId);
    }
}
