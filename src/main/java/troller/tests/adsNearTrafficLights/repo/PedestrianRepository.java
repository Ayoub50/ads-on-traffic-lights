package troller.tests.adsNearTrafficLights.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import troller.tests.adsNearTrafficLights.model.PedestrianButton;

@Repository
public interface PedestrianRepository extends JpaRepository<PedestrianButton,Long>{
    
}
