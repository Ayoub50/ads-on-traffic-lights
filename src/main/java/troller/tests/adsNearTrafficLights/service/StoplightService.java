package troller.tests.adsNearTrafficLights.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Stoplight createStoplight(Map<String, Object> stoplightData) {
        // Check if all required fields are present
        List<String> requiredFields = Arrays.asList("longitude", "latitude", "redColor", "yellowColor", "greenColor", "producer");
        for (String field : requiredFields) {
            if (!stoplightData.containsKey(field)) {
                throw new IllegalArgumentException("Missing required field: " + field);
            }
        }

        // Fetch the User object from the database using the producer ID
        Long producerId = Long.parseLong(stoplightData.get("producer").toString());
        User producer = userRepository.findById(producerId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Stoplight stoplight = new Stoplight();
        stoplight.setLongitude(Double.parseDouble(stoplightData.get("longitude").toString()));
        stoplight.setLatitude(Double.parseDouble(stoplightData.get("latitude").toString()));
        stoplight.setRedColor(Boolean.parseBoolean(stoplightData.get("redColor").toString()));
        stoplight.setYellowColor(Boolean.parseBoolean(stoplightData.get("yellowColor").toString()));
        stoplight.setGreenColor(Boolean.parseBoolean(stoplightData.get("greenColor").toString()));
        stoplight.setProducer(producer);

        return stoplightRepository.save(stoplight);
    }
}

