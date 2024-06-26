package pro.luxen.movieapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.luxen.movieapp.model.User;
import pro.luxen.movieapp.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    // Add more endpoints for login, logout, etc.
}
