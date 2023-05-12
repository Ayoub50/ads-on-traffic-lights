package troller.tests.adsNearTrafficLights.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import troller.tests.adsNearTrafficLights.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

