package troller.tests.adsNearTrafficLights.service.consumer;

import troller.tests.adsNearTrafficLights.controller.AdvertisementController;
import troller.tests.adsNearTrafficLights.model.Advertisement;
import troller.tests.adsNearTrafficLights.model.TrafficLightEvent;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class TrafficLightEventConsumer {

    @Autowired
    private AdvertisementController advertisementController;

    @KafkaListener(topics = "traffic-light-events", groupId = "my-group")
    public void consumeTrafficLightEvent(String eventJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            TrafficLightEvent event = objectMapper.readValue(eventJson, TrafficLightEvent.class);

            if ("RED".equals(event.getState())) {
                displayAdvertisement();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private void displayAdvertisement() {
        Advertisement ad = new Advertisement();
        ad.setContent("This is a sample ad");
        ad.setTimeStamp(LocalDateTime.now());

        advertisementController.displayAdvertisement(ad);
    }
}
