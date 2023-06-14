package troller.tests.adsNearTrafficLights.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import troller.tests.adsNearTrafficLights.model.Stoplight;
import troller.tests.adsNearTrafficLights.model.Subscription;
import troller.tests.adsNearTrafficLights.model.User;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long>{
    List<Subscription> findAllByStoplightAndUser(Optional<Stoplight> stoplight, User user);
}
