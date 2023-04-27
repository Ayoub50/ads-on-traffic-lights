package troller.tests.adsNearTrafficLights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AdsNearTrafficLightsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdsNearTrafficLightsApplication.class, args);
	}

}
