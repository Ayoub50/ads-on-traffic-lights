package troller.tests.adsNearTrafficLights.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import troller.tests.adsNearTrafficLights.model.User;
import troller.tests.adsNearTrafficLights.repo.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Method to create a user
    public User createUser(User user) {
        // Perform validations, such as checking if the username already exists
        // Save the user to the database
        return userRepository.save(user);
    }

    // Method to authenticate login credentials
    public User authenticate(String username, String password) {
        // Retrieve the user with the given username
        // Check if the password matches
        // If the credentials are valid, return the user object
        // Otherwise, throw an exception or return an appropriate response
        return null;
    }
}

