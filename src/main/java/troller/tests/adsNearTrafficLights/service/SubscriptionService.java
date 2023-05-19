package troller.tests.adsNearTrafficLights.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import troller.tests.adsNearTrafficLights.dto.SubscriptionResponse;
import troller.tests.adsNearTrafficLights.model.User;
import troller.tests.adsNearTrafficLights.repo.UserRepository;

@Service
public class SubscriptionService {

    @Autowired
    private UserRepository userRepository;

    public SubscriptionResponse createSubscription(Map<String, Object> subcriptionData){
        // Check if all required fields are present
        List<String> requiredFields = Arrays.asList("consumer_username", "stoplight_id", "pedestrinButton_id", "topic_name");
        for (String field : requiredFields) {
            if (!subcriptionData.containsKey(field)) {
                throw new IllegalArgumentException("Missing required field: " + field);
            }
        }
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // Extract the username from the UserDetails
        String username = userDetails.getUsername();

        // Fetch the User object from the database using the username
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        if(!user.getUserType().equals("consumer")){
            throw new IllegalArgumentException("Only producers are enabled to create stoplights");
        }
        return null;
    }
    
}
