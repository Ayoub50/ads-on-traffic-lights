package troller.tests.adsNearTrafficLights.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import troller.tests.adsNearTrafficLights.model.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long>{
    
}
