//package se331.project2backend.security.user;
//
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//
//@Service
//@Slf4j
//@RequiredArgsConstructor
//public class UserServiceImpl implements UserService {
//    final UserDao userDao;
//
//    @Override
//    @Transactional
//    public User save(User user) {
//        return userDao.save(user);
//    }
//
//    @Override
//    @Transactional
//    public User findByUsername(String username) {
//        return userDao.findByUsername(username);
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        return userDao.findAllUsers();
//    }
//
//    @Override
//    public User getUserById(Integer id) {
//        return userDao.findById(id).orElse(null);
//    }
//}


package se331.project2backend.security.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    final UserDao userDao;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    @Transactional
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
        return UserMapper.toDTO(user);
    }

    @Override
    public UserDTO upgradeUserToAdmin(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
        if (!user.getRoles().contains(Role.ROLE_ADMIN)) {
            user.getRoles().add(Role.ROLE_ADMIN);
            userRepository.save(user);
        }
        return UserMapper.toDTO(user);
    }

    @Override
    public UserDTO downgradeUserToRegular(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
        user.getRoles().remove(Role.ROLE_ADMIN);
        userRepository.save(user);
        return UserMapper.toDTO(user);
    }
}
