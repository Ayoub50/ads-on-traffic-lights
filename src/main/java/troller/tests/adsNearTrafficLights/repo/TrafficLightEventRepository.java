package troller.tests.adsNearTrafficLights.repo;

import troller.tests.adsNearTrafficLights.model.TrafficLightEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrafficLightEventRepository extends JpaRepository<TrafficLightEvent, Long> {
}
