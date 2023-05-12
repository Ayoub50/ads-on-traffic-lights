package troller.tests.adsNearTrafficLights.interfaces.projection;

import java.time.LocalDateTime;

public interface UserProjection {
    Long getId();
    String getUsername();
    LocalDateTime getTimestamp();
}

