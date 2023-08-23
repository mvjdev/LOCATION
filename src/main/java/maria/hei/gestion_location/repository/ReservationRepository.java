package maria.hei.gestion_location.repository;

import maria.hei.gestion_location.entity.Reservation;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservationRepository {

    private Connection connection;

    public void createReservation(Reservation reservation) throws SQLException {
        String sql = "INSERT INTO reservation (start_date, end_date, id_user) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDate(1, reservation.getStartDate());
        statement.setDate(2, reservation.getEndDate());
        statement.setInt(3, reservation.getUserId());
        statement.executeUpdate();
    }

    public Reservation getReservationById(int id) throws SQLException {
        String sql = "SELECT * FROM reservation WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return new Reservation(
                    resultSet.getInt("id"),
                    resultSet.getDate("start_date"),
                    resultSet.getDate("end_date"),
                    resultSet.getInt("id_user")
            );
        }
        return null;
    }

    public List<Reservation> getAllReservations() throws SQLException {
        String sql = "SELECT * FROM reservation";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Reservation> reservations = new ArrayList<>();
        while (resultSet.next()) {
            reservations.add(new Reservation(
                    resultSet.getInt("id"),
                    resultSet.getDate("start_date"),
                    resultSet.getDate("end_date"),
                    resultSet.getInt("id_user")
            ));
        }
        return reservations;
    }

    public void updateReservation(Reservation reservation) throws SQLException {
        String sql = "UPDATE reservation SET start_date = ?, end_date = ?, id_user = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDate(1, reservation.getStartDate());
        statement.setDate(2, reservation.getEndDate());
        statement.setInt(3, reservation.getUserId());
        statement.setInt(4, reservation.getId());
        statement.executeUpdate();
    }

    public void deleteReservation(int id) throws SQLException {
        String sql = "DELETE FROM reservation WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }
}

