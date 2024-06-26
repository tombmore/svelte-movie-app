package com.saml.movieking.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(path = "api/v1/users")
public class UsersController {

    private final UsersService userService;

    @Autowired
    public UsersController(UsersService userService) {
        this.userService = userService;
    }

    /*
    @GetMapping
    public List<Users> getUsers() {
        return userService.getUsers();
    }

     */

    @PostMapping(path = "register")
    public ResponseEntity<?> registerUser(@RequestBody Users user) {
        return userService.registerUser(user);
    }

    @PostMapping(path = "login")
    public ResponseEntity<?> loginUser(@RequestBody Users user) { return userService.loginUser(user); }

    @PostMapping(path = "logout")
    public String logoutUser(@RequestBody Users user) { return userService.logoutUser(user); }

    /*
    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }
    @PutMapping(path = "{userId}")
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String dob
    ) {
        userService.updateUser(userId, name, email, password, dob);
    }
     */
}
