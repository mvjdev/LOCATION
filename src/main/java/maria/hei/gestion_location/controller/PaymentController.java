package maria.hei.gestion_location.controller;

import maria.hei.gestion_location.entity.Payment;
import maria.hei.gestion_location.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(Connection connection) {
        this.paymentService = new PaymentService(connection);
    }

    @PostMapping
    public void createPayment(@RequestBody Payment payment) {
        try {
            paymentService.createPayment(payment);
            System.out.println("Payment created successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to create payment: " + e.getMessage());
        }
    }

    @GetMapping("/{paymentId}")
    public void getPaymentById(@PathVariable int paymentId) {
        try {
            Payment payment = paymentService.getPaymentById(paymentId);
            if (payment != null) {
                System.out.println("Payment found: " + payment);
            } else {
                System.out.println("Payment not found.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to get payment: " + e.getMessage());
        }
    }

    @GetMapping
    public void getAllPayments() {
        try {
            List<Payment> payments = paymentService.getAllPayments();
            if (!payments.isEmpty()) {
                System.out.println("Payments found:");
                for (Payment payment : payments) {
                    System.out.println(payment);
                }
            } else {
                System.out.println("No payments found.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to get payments: " + e.getMessage());
        }
    }

    @PutMapping("/{paymentId}")
    public void updatePayment(@PathVariable int paymentId, @RequestBody Payment payment) {
        try {
            payment.setId(paymentId);
            paymentService.updatePayment(payment);
            System.out.println("Payment updated successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to update payment: " + e.getMessage());
        }
    }

    @DeleteMapping("/{paymentId}")
    public void deletePayment(@PathVariable int paymentId) {
        try {
            paymentService.deletePayment(paymentId);
            System.out.println("Payment deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to delete payment: " + e.getMessage());
        }
    }
}
