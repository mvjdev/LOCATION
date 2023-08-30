package maria.hei.gestion_location.controller;

import maria.hei.gestion_location.entity.Reservation;
import maria.hei.gestion_location.service.ReservationService.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> getAllReservations() throws SQLException {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{reservationId}")
    public Reservation getReservationById(@PathVariable int reservationId) throws SQLException {
        return reservationService.getReservationById(reservationId);
    }

    @PostMapping
    public void createReservation(@RequestBody Reservation reservation) throws SQLException {
        reservationService.createReservation(reservation);
    }

    @PutMapping("/{reservationId}")
    public void updateReservation(@PathVariable int reservationId, @RequestBody Reservation reservation) throws SQLException {
        // Implement reservation update logic using reservationService
        reservation.setId(reservationId);
        reservationService.updateReservation(reservation);
    }

    @DeleteMapping("/{reservationId}")
    public void deleteReservation(@PathVariable int reservationId) throws SQLException {
        reservationService.deleteReservation(reservationId);
    }
}
