package maria.hei.gestion_location.controller;

import maria.hei.gestion_location.entity.Payment;
import maria.hei.gestion_location.service.PaymentService.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<Payment> getAllPayments() throws SQLException {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{paymentId}")
    public Payment getPaymentById(@PathVariable int paymentId) throws SQLException {
        return paymentService.getPaymentById(paymentId);
    }

    @PostMapping
    public void createPayment(@RequestBody Payment payment) throws SQLException {
        paymentService.createPayment(payment);
    }

    @PutMapping("/{paymentId}")
    public void updatePayment(@PathVariable int paymentId, @RequestBody Payment payment) throws SQLException {
        // Implémentation de la mise à jour du paiement
        paymentService.updatePayment(payment);
    }

    @DeleteMapping("/{paymentId}")
    public void deletePayment(@PathVariable int paymentId) throws SQLException {
        paymentService.deletePayment(paymentId);
    }
}
