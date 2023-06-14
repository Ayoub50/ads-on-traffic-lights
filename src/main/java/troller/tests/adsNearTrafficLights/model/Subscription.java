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
    private Boolean active;

    @Column(name="recurrent")
    private Boolean recurrent;
    
    @Column(name="start")
    private LocalDateTime start; ;
    
    @Column(name="end")
    private LocalDateTime end; 

    @ManyToOne
    @JoinColumn(name="consumer")
    private User user;

    @ManyToOne
    @JoinColumn(name="topic")
    private Topic topic;

    @ManyToOne
    @JoinColumn(name="stoplight")
    private Stoplight stoplight;
    
    @ManyToOne
    @JoinColumn(name="pedestrianbutton")
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

    public Boolean getActive(){
        return this.active;
    }

    public void setActive(boolean active){
        this.active = active;
    }

    public Boolean getRecurrent(){
        return this.recurrent;
    }

    public void setRecurrent(boolean recurrent){
        this.recurrent = recurrent;
    }

    public LocalDateTime getStart(){
        return this.start;
    }

    public void setStart(LocalDateTime start){
        this.start = start;
    }

    public LocalDateTime getEnd(){
        return this.end;
    }

    public void setEnd(LocalDateTime end){
        this.end = end;
    }

    public User getConsumer(){
        return this.user;
    }

    public void setConsumer(User consumer){
        this.user = consumer;
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
