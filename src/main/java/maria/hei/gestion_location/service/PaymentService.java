package maria.hei.gestion_location.service;

import maria.hei.gestion_location.entity.Payment;
import maria.hei.gestion_location.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Service
public class PaymentService {

    private PaymentRepository paymentRepository;

    public PaymentService(Connection connection) {
        this.paymentRepository = new PaymentRepository();
    }

    public void createPayment(Payment payment) throws SQLException {
        paymentRepository.createPayment(payment);
    }

    public Payment getPaymentById(int paymentId) throws SQLException {
        return paymentRepository.getPaymentById(paymentId);
    }

    public List<Payment> getAllPayments() throws SQLException {
        return paymentRepository.getAllPayments();
    }

    public void updatePayment(Payment payment) throws SQLException {
        paymentRepository.updatePayment(payment);
    }

    public void deletePayment(int paymentId) throws SQLException {
        paymentRepository.deletePayment(paymentId);
    }
}
