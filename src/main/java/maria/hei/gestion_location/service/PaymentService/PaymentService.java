package maria.hei.gestion_location.service.PaymentService;

import maria.hei.gestion_location.entity.Payment;
import maria.hei.gestion_location.repository.OffersRepository;
import maria.hei.gestion_location.service.PaymentRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service

public class PaymentService implements PaymentInterface {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void createPayment(Payment payment) throws SQLException {
        paymentRepository.createPayment(payment);
    }

    @Override
    public Payment getPaymentById(int paymentId) throws SQLException {
        return paymentRepository.getPaymentById(paymentId);
    }

    @Override
    public List<Payment> getAllPayments() throws SQLException {
        return paymentRepository.getAllPayments();
    }

    @Override
    public void updatePayment(Payment payment) throws SQLException {
        paymentRepository.updatePayment(payment);
    }

    @Override
    public void deletePayment(int paymentId) throws SQLException {
        paymentRepository.deletePayment(paymentId);
    }
}
