package troller.tests.adsNearTrafficLights.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "traffic_light_event")
public class TrafficLightEvent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name="state")
    public String state;

    @Column(name="timestamp")
    public LocalDateTime timestamp;

    public void setId(Long id){
        this.id = id;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setTimeStamp(LocalDateTime timestamp){
        this.timestamp = timestamp;
    }

    public Long getId(){
        return this.id;
    }

    public String getState(){
        return this.state;
    }

    public LocalDateTime getTimeStamp(){
        return this.timestamp;
    }

}
