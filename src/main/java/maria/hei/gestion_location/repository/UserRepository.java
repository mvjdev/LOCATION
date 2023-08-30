package maria.hei.gestion_location.repository;

import maria.hei.gestion_location.entity.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements RepositoryInterface<User> {
    private final Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User getById(int id) {
        User user = null;
        String selectByIdSQL = "SELECT * FROM \"user\" WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(selectByIdSQL)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                );
            }

            System.out.println("Data select by id query executed successfully!");
        } catch (SQLException e) {
            System.out.println("Error executing select by id query: " + e.getMessage());
        }

        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        String selectAllSQL = "SELECT * FROM \"user\"";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectAllSQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                ));
            }

            System.out.println("Data select all query executed successfully!");
        } catch (SQLException e) {
            System.out.println("Error executing select all query: " + e.getMessage());
        }
        System.out.println(users);
        return users;
    }

    @Override
    public User create(User user) {
        String insertSQL = "INSERT INTO \"user\" (name, email, password) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(insertSQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

            System.out.println("Data create query executed successfully!");
        } catch (SQLException e) {
            System.out.println("Error executing create query: " + e.getMessage());
        }

        return user;
    }

    @Override
    public void update(User user) {
        String updateSQL = "UPDATE \"user\" SET name = ?, email = ?, password = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(updateSQL)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setLong(4, user.getId());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Updating user failed, no rows affected.");
            }

            System.out.println("Data update query executed successfully!");
        } catch (SQLException e) {
            System.out.println("Error executing update query: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String deleteSQL = "DELETE FROM \"user\" WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(deleteSQL)) {
            statement.setInt(1, id);

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Deleting user failed, no rows affected.");
            }

            System.out.println("Data delete query executed successfully!");
        } catch (SQLException e) {
            System.out.println("Error executing delete query: " + e.getMessage());
        }
    }
}
