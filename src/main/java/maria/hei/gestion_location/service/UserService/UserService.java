package maria.hei.gestion_location.service.UserService;

import maria.hei.gestion_location.entity.User;
import maria.hei.gestion_location.repository.RepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserInterface {
    private final RepositoryInterface<User> userRepository;

    public UserService(RepositoryInterface<User> userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getById(id);
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(int id) {

    }
}
