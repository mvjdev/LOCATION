package maria.hei.gestion_location.service.PaymentService;

import maria.hei.gestion_location.entity.Payment;
import maria.hei.gestion_location.entity.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PaymentService implements PaymentInterface{
    private final PaymentInterface<Payment> paymentRepository ;

    public PaymentService(PaymentInterface<Payment> userRepository) {
        this.paymentRepository = paymentRepository;
    }
    @Override
    public Payment createPayment(Payment payment) {
        return null;
    }

    @Override
    public List<Payment> getAllPayments() {
        return null;
    }

    @Override
    public Payment getPaymentById(int id) {
        return null;
    }

    @Override
    public Payment updatePayment(Payment payment) {
        return null;
    }

    @Override
    public void deletePayment(int id) {

    }
}
