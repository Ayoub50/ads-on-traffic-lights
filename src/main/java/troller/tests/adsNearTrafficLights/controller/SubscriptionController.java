package troller.tests.adsNearTrafficLights.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import troller.tests.adsNearTrafficLights.dto.SubscriptionResponse;
import troller.tests.adsNearTrafficLights.service.SubscriptionService;

@RestController
@RequestMapping("subscription")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;
    
    @PostMapping("/create")
    public ResponseEntity<?> addSubscription(@RequestBody Map<String, Object> subscriptionData){
        SubscriptionResponse subscription = subscriptionService.createSubscription(subscriptionData);
        return ResponseEntity.ok(subscription);
    }

}
