package troller.tests.adsNearTrafficLights.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import troller.tests.adsNearTrafficLights.dto.SubscriptionResponse;
import troller.tests.adsNearTrafficLights.model.PedestrianButton;
import troller.tests.adsNearTrafficLights.model.Stoplight;
import troller.tests.adsNearTrafficLights.model.Subscription;
import troller.tests.adsNearTrafficLights.model.Topic;
import troller.tests.adsNearTrafficLights.model.User;
import troller.tests.adsNearTrafficLights.repo.PedestrianRepository;
import troller.tests.adsNearTrafficLights.repo.StoplightRepository;
import troller.tests.adsNearTrafficLights.repo.SubscriptionRepository;
import troller.tests.adsNearTrafficLights.repo.TopicRepository;
import troller.tests.adsNearTrafficLights.repo.UserRepository;
import troller.tests.adsNearTrafficLights.util.BodyApis;

@Service
public class SubscriptionService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private StoplightRepository stoplightRepository;

    @Autowired
    private PedestrianRepository pedestrianRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public SubscriptionResponse createSubscription(Map<String, Object> subcriptionData){
        // Check if all required fields are present
        List<String> requiredFields = Arrays.asList("consumer_username", "stoplight_id", "pedestrianButton_id", "topic_name");
        BodyApis.isMissingRequiredField(requiredFields,subcriptionData);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // Extract the username from the UserDetails
        String username = userDetails.getUsername();

        // Fetch the User object from the database using the username
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        if(user.getUserType().equals("producer")){
            throw new IllegalArgumentException("Only consumers are enabled to subscribe");
        }

        Optional<Topic> topic = topicRepository.findByName(subcriptionData.get("topic_name").toString());
        if(!topic.isPresent()){
            throw new IllegalArgumentException("The topic provided does not exist");
        }

        // Now here add code to create new subscription
        Subscription sub = new Subscription();
        sub.setConsumer(user);
        sub.setTopic(topic.orElse(null));
        switch(topic.get().getName()){
            case "traffic_lights":
                Optional<Stoplight> stoplight = stoplightRepository.findById(Long.parseLong(subcriptionData.get("stoplight_id").toString()));
                if(!stoplight.isPresent()){
                    throw new IllegalArgumentException("The stoplight provided does not exist");
                }
                sub.setStoplight(stoplight.orElse(null));
                sub.setPedestrianbutton(null);
                break;
            case "pedestrian_reservations":
                Optional<PedestrianButton> pedestrianButton = pedestrianRepository.findById(Long.parseLong(subcriptionData.get("stoplight_id").toString()));
                if(!pedestrianButton.isPresent()){
                    throw new IllegalArgumentException("The pedestrian button provided does not exist");
                }
                sub.setPedestrianbutton(pedestrianButton.orElse(null));
                sub.setStoplight(null);
                break;
            default:
                throw new IllegalArgumentException("Something wrong, topic provided not mapped.");
                
        }
        sub.setActive(true);
        subscriptionRepository.save(sub);

        return sub.toDTO();
    }
    
}
