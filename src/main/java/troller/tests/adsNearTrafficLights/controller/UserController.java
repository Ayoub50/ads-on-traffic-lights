package troller.tests.adsNearTrafficLights.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import troller.tests.adsNearTrafficLights.model.User;
import troller.tests.adsNearTrafficLights.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        // Call the createUser method from the UserService
        // Return a success response or an appropriate error message
        return null; 
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        // Call the authenticate method from the UserService
        // Return a success response with the user object or an appropriate error message
        return null;
    }
}
