package troller.tests.adsNearTrafficLights.model;

import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name="stoplight")
public class Stoplight {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="longitude")
    private Double longitude;

    @Column(name="latitude")
    private Double latitude;

    @Column(name="red_color")
    private boolean redColor;

    @Column(name="yellow_color")
    private boolean yellowColor;

    @Column(name="green_color")
    private boolean greenColor;

    @Column(name="timestamp")
    @CreationTimestamp
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name="producer_id")
    private User producer;

    // Getters and Setters

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Double getLongitude() {
        return longitude;
    }
    
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    
    public Double getLatitude() {
        return latitude;
    }
    
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    
    public boolean getRedColor() {
        return redColor;
    }
    
    public void setRedColor(boolean redColor) {
        this.redColor = redColor;
    }
    
    public boolean getYellowColor() {
        return yellowColor;
    }
    
    public void setYellowColor(boolean yellowColor) {
        this.yellowColor = yellowColor;
    }
    
    public boolean getGreenColor() {
        return greenColor;
    }
    
    public void setGreenColor(boolean greenColor) {
        this.greenColor = greenColor;
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    public User getProducer() {
        return producer;
    }
    
    public void setProducer(User producer) {
        this.producer = producer;
    }
    
}