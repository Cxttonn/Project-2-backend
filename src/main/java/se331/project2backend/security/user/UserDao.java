package se331.project2backend.security.user;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    User findByUsername(String username);

    User save(User user);

    List<User> findAllUsers();

    Optional<User> findById(Integer id);
}