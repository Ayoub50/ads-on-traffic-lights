package troller.tests.adsNearTrafficLights.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import troller.tests.adsNearTrafficLights.model.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long>{
    Optional<Topic> findByName(String name);
}
