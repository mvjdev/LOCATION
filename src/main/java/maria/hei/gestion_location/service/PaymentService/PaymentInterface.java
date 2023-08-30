package maria.hei.gestion_location.service.PaymentService;

import maria.hei.gestion_location.entity.Payment;

import java.util.List;

public interface PaymentInterface {
    Payment createPayment(Payment payment);

    List<Payment> getAllPayments();

    Payment getPaymentById(int id);

    Payment updatePayment(Payment payment);

    void deletePayment(int id);
}
