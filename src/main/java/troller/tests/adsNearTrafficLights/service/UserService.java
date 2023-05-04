package troller.tests.adsNearTrafficLights.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import troller.tests.adsNearTrafficLights.model.User;
import troller.tests.adsNearTrafficLights.repo.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("A user with the given username already exists");
        }
        // You should hash the password before saving it to the database
        return userRepository.save(user);
    }

    // Method to authenticate login credentials
    public User authenticate(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user.orElse(null);
        } else {
            throw new IllegalArgumentException("Invalid username or password");
        }
    }
}

