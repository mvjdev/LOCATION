package maria.hei.gestion_location.repository;

import maria.hei.gestion_location.entity.Payment;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepository {

    private Connection connection;

    public void createPayment(Payment payment) throws SQLException {
        String sql = "INSERT INTO payment (paid, method, reservation_id) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setBoolean(1, payment.isPaid());
            statement.setString(2, payment.getMethod());
            statement.setInt(3, payment.getReservationId());
            statement.executeUpdate();
        }
    }

    public Payment getPaymentById(int paymentId) throws SQLException {
        String sql = "SELECT * FROM payment WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, paymentId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapPayment(resultSet);
                }
            }
        }
        return null;
    }

    public List<Payment> getAllPayments() throws SQLException {
        String sql = "SELECT * FROM payment";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            List<Payment> payments = new ArrayList<>();
            while (resultSet.next()) {
                Payment payment = mapPayment(resultSet);
                payments.add(payment);
            }
            return payments;
        }
    }

    public void updatePayment(Payment payment) throws SQLException {
        String sql = "UPDATE payment SET paid = ?, method = ?, reservation_id = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setBoolean(1, payment.isPaid());
            statement.setString(2, payment.getMethod());
            statement.setInt(3, payment.getReservationId());
            statement.setInt(4, payment.getId());
            statement.executeUpdate();
        }
    }

    public void deletePayment(int paymentId) throws SQLException {
        String sql = "DELETE FROM payment WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, paymentId);
            statement.executeUpdate();
        }
    }

    private Payment mapPayment(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        boolean paid = resultSet.getBoolean("paid");
        String method = resultSet.getString("method");
        int reservationId = resultSet.getInt("reservation_id");
        return new Payment(id, paid, method, reservationId);
    }
}
