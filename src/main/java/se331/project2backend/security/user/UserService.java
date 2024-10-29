package se331.project2backend.security.user;

import jakarta.transaction.Transactional;

import java.util.List;

//public interface UserService {
//    User save(User user);
//
//    @Transactional
//    User findByUsername(String username);
//
//    List<User> getAllUsers();
//    User getUserById(Integer id);
//
//}

public interface UserService {
    User save(User user);

    @Transactional
    User findByUsername(String username);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Integer id);
    UserDTO upgradeUserToAdmin(Integer id);
    UserDTO downgradeUserToRegular(Integer id);
}
