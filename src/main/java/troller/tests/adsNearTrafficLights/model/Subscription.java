package troller.tests.adsNearTrafficLights.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import troller.tests.adsNearTrafficLights.dto.SubscriptionResponse;

@Entity
@Table(name="subscription")
public class Subscription {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="active")
    private boolean active;
    
    @ManyToOne
    @JoinColumn(name="consumer_id")
    private User consumer;

    @ManyToOne
    @JoinColumn(name="topic_id")
    private Topic topic;

    @ManyToOne
    @JoinColumn(name="stoplight_id")
    private Stoplight stoplight;
    
    @ManyToOne
    @JoinColumn(name="pedestrianbutton_id")
    private PedestrianButton pedestrianButton;

    @Column(name="timestamp")
    @CreationTimestamp
    private LocalDateTime timestamp;

    // setters and getters

    public SubscriptionResponse toDTO(){
        SubscriptionResponse dto = new SubscriptionResponse();
        dto.setId(this.id);
        dto.setTimestamp(this.timestamp);
        return dto;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public boolean getActive(){
        return this.active;
    }

    public void setActive(boolean active){
        this.active = active;
    }

    public User getConsumer(){
        return this.consumer;
    }

    public void setConsumer(User consumer){
        this.consumer = consumer;
    }

    public Stoplight getStoplight(){
        return this.stoplight;
    }

    public void setStoplight(Stoplight stoplight){
        this.stoplight = stoplight;
    }

    public PedestrianButton getPedestrianbutton(){
        return this.pedestrianButton;
    }

    public void setPedestrianbutton(PedestrianButton pedestrianButton){
        this.pedestrianButton = pedestrianButton;
    }

    public Topic geTopic(){
        return this.topic;
    }

    public void setTopic(Topic topic){
        this.topic = topic;
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    } 
    
}
