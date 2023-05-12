package troller.tests.adsNearTrafficLights.controller;

import troller.tests.adsNearTrafficLights.model.Advertisement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/advertisement")
public class AdvertisementController {

    public static Logger logger = LoggerFactory.getLogger(AdvertisementController.class);

    @PostMapping("/display")
    public ResponseEntity<Void> displayAdvertisement(@RequestBody Advertisement ad) {
        logger.info("Displaying ad: " + ad.getContent());
        return ResponseEntity.ok().build();
    }
}

