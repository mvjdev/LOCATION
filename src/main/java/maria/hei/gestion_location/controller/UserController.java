package maria.hei.gestion_location.controller;

import maria.hei.gestion_location.entity.User;
import maria.hei.gestion_location.repository.UserRepository;
import maria.hei.gestion_location.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(Connection connection){
        this.userService = new UserService(new UserRepository(connection));
    }

    @PostMapping
    public void createUser(@RequestBody User user) throws SQLException {
        userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int userId) throws SQLException {
        return userService.getUserById(userId);
    }

    @GetMapping
    public List<User> getAllUsers() throws SQLException {
        return userService.getAllUsers();
    }

    @PutMapping
    public void updateUser(@RequestBody User user) throws SQLException {
        userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int userId) throws SQLException {
        userService.deleteUser(userId);
    }
}
