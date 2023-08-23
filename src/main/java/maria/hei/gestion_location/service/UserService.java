package maria.hei.gestion_location.service;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import maria.hei.gestion_location.entity.User;

import maria.hei.gestion_location.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        // Implement any validation or business logic before creating the user
        userRepository.createUser(user);
    }

    public User getUserById(int userId) {
        // Implement any additional logic before fetching the user
        return userRepository.getUserById(userId);
    }

    public List<User> getAllUsers() {
        // Implement any logic before fetching all users
        return userRepository.getAllUsers();
    }

    public void updateUser(User user) {
        // Implement any validation or logic before updating the user
        userRepository.updateUser(user);
    }

    public void deleteUser(int userId) {
        // Implement any logic before deleting the user
        userRepository.deleteUser(userId);
    }
}

