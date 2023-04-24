package troller.tests.adsNearTrafficLights.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "traffic_light_event")
public class TrafficLightEvent {
    
    @Column(name="id")
    public String id;

    @Column(name="state")
    public String state;

    @Column(name="timestamp")
    public LocalDateTime timestamp;

    public void setId(String id){
        this.id = id;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setTimeStamp(LocalDateTime timestamp){
        this.timestamp = timestamp;
    }

    public String getId(){
        return this.id;
    }

    public String getState(){
        return this.state;
    }

    public LocalDateTime getTimeStamp(){
        return this.timestamp;
    }

}
