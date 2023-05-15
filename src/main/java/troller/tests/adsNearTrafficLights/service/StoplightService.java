package troller.tests.adsNearTrafficLights.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import troller.tests.adsNearTrafficLights.dto.StoplightResponse;
import troller.tests.adsNearTrafficLights.model.Stoplight;
import troller.tests.adsNearTrafficLights.model.User;
import troller.tests.adsNearTrafficLights.repo.StoplightRepository;
import troller.tests.adsNearTrafficLights.repo.UserRepository;

@Service
public class StoplightService {

    @Autowired
    private StoplightRepository stoplightRepository;

    @Autowired
    private UserRepository userRepository;

    public String createStoplight(Map<String, Object> stoplightData) {
        // Check if all required fields are present
        List<String> requiredFields = Arrays.asList("longitude", "latitude", "redColor", "yellowColor", "greenColor");
        for (String field : requiredFields) {
            if (!stoplightData.containsKey(field)) {
                throw new IllegalArgumentException("Missing required field: " + field);
            }
        }
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // Extract the username from the UserDetails
        String username = userDetails.getUsername();

        // Fetch the User object from the database using the username
        User producer = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Stoplight stoplight = new Stoplight();
        stoplight.setLongitude(Double.parseDouble(stoplightData.get("longitude").toString()));
        stoplight.setLatitude(Double.parseDouble(stoplightData.get("latitude").toString()));
        stoplight.setRedColor(Boolean.parseBoolean(stoplightData.get("redColor").toString()));
        stoplight.setYellowColor(Boolean.parseBoolean(stoplightData.get("yellowColor").toString()));
        stoplight.setGreenColor(Boolean.parseBoolean(stoplightData.get("greenColor").toString()));
        stoplight.setProducer(producer);
        stoplightRepository.save(stoplight);

        return "Stoplight created successfully.";
    }

    public List<StoplightResponse> getAllStoplights() {
        List<Stoplight> res = stoplightRepository.findAll();
        return res.stream().map(Stoplight::toDTO).collect(Collectors.toList());
    }
    
}

