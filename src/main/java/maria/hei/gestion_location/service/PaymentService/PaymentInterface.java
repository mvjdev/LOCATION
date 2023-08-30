package maria.hei.gestion_location.service.PaymentService;

import maria.hei.gestion_location.entity.Payment;

import java.sql.SQLException;
import java.util.List;

public interface PaymentInterface {
    void createPayment(Payment payment) throws SQLException;
    Payment getPaymentById(int paymentId) throws SQLException;
    List<Payment> getAllPayments() throws SQLException;
    void updatePayment(Payment payment) throws SQLException;
    void deletePayment(int paymentId) throws SQLException;
}
