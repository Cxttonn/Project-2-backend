//package se331.project2backend.security.user;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import lombok.RequiredArgsConstructor;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/users")
//@RequiredArgsConstructor
//public class UserController {
//    private final UserService userService;
//
//    @GetMapping
//    public List<User> getAllUsers() {
//        return userService.getAllUsers();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
//        User user = userService.getUserById(id);
//        return ResponseEntity.ok(user);
//    }
//}
//
package se331.project2backend.security.user;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/{id}/upgrade")
    public ResponseEntity<UserDTO> upgradeUserToAdmin(@PathVariable Integer id) {
        UserDTO user = userService.upgradeUserToAdmin(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/{id}/downgrade")
    public ResponseEntity<UserDTO> downgradeUserToRegular(@PathVariable Integer id) {
        UserDTO user = userService.downgradeUserToRegular(id);
        return ResponseEntity.ok(user);
    }
}