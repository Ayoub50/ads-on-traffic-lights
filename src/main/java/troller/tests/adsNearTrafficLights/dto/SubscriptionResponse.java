package troller.tests.adsNearTrafficLights.dto;

import java.time.LocalDateTime;

public class SubscriptionResponse {
    private Long id;
    private LocalDateTime timestamp;

    // setters and getters

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    } 
    
}
