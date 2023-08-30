package maria.hei.gestion_location.service.UserService;

import maria.hei.gestion_location.entity.User;

import java.util.List;

public interface UserInterface {
    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(int id);

    User updateUser(User user);

    void deleteUser(int id);
}
