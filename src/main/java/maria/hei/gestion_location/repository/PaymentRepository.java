package maria.hei.gestion_location.service;

import maria.hei.gestion_location.entity.Payment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentRepository {

    private final List<Payment> paymentList = new ArrayList<>();

    public void createPayment(Payment payment) {
        paymentList.add(payment);
    }

    public Payment getPaymentById(int paymentId) {
        for (Payment payment : paymentList) {
            if (payment.getId() == paymentId) {
                return payment;
            }
        }
        return null;
    }

    public List<Payment> getAllPayments() {
        return paymentList;
    }

    public void updatePayment(Payment updatedPayment) {
        for (Payment payment : paymentList) {
            if (payment.getId() == updatedPayment.getId()) {
                payment.setPaid(updatedPayment.isPaid());
                payment.setMethod(updatedPayment.getMethod());
                payment.setReservationId(updatedPayment.getReservationId());
                break;
            }
        }
    }

    public void deletePayment(int paymentId) {
        Payment paymentToRemove = null;
        for (Payment payment : paymentList) {
            if (payment.getId() == paymentId) {
                paymentToRemove = payment;
                break;
            }
        }
        if (paymentToRemove != null) {
            paymentList.remove(paymentToRemove);
        }
    }
}
