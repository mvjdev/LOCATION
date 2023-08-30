package maria.hei.gestion_location.controller;

import maria.hei.gestion_location.entity.Payment;
import maria.hei.gestion_location.repository.PaymentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentRepository paymentRepository;

    public PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @PostMapping
    public ResponseEntity<Void> createPayment(@RequestBody Payment payment) throws SQLException {
        paymentRepository.createPayment(payment);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable int id) throws SQLException {
        Payment payment = paymentRepository.getPaymentById(id);
        return ResponseEntity.ok(payment);
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() throws SQLException {
        List<Payment> payments = paymentRepository.getAllPayments();
        return ResponseEntity.ok(payments);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePayment(@PathVariable int id, @RequestBody Payment payment) throws SQLException {
        payment.setId(id); // Set the ID based on the path variable
        paymentRepository.updatePayment(payment);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable int id) throws SQLException {
        paymentRepository.deletePayment(id);
        return ResponseEntity.ok().build();
    }
}
