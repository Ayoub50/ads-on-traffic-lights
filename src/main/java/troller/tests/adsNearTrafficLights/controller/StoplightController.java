package troller.tests.adsNearTrafficLights.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import troller.tests.adsNearTrafficLights.model.Stoplight;
import troller.tests.adsNearTrafficLights.service.StoplightService;

@RestController
@RequestMapping("/stoplight")
public class StoplightController {

    @Autowired
    private StoplightService stoplightService;

    @PostMapping("/create")
    public ResponseEntity<?> createStoplight(@RequestBody Map<String, Object> stoplightData) {
        try {
            Stoplight stoplight = stoplightService.createStoplight(stoplightData);
            return ResponseEntity.ok(stoplight);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}

