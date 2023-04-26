package troller.tests.adsNearTrafficLights.service.producer;

import troller.tests.adsNearTrafficLights.model.TrafficLightEvent;
import troller.tests.adsNearTrafficLights.repo.TrafficLightEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class TrafficLightEventProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private TrafficLightEventRepository trafficLightEventRepository;

    public void sendTrafficLightEvent(TrafficLightEvent event) {
        // Save the TrafficLightEvent in the database
        TrafficLightEvent savedEvent = trafficLightEventRepository.save(event);

        // Convert the saved TrafficLightEvent object to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String eventJson;
        try {
            eventJson = objectMapper.writeValueAsString(savedEvent);
            // Send the JSON string to the "traffic-light-events" topic
            kafkaTemplate.send("traffic-light-events", eventJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

