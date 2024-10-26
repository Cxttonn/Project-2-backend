package se331.project2backend.security.user;

public interface UserDao {
    User findByUsername(String username);

    User save(User user);
}