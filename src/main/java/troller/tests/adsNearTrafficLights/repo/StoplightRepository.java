package troller.tests.adsNearTrafficLights.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import troller.tests.adsNearTrafficLights.model.Stoplight;

@Repository
public interface StoplightRepository extends JpaRepository<Stoplight, Long> {
}
