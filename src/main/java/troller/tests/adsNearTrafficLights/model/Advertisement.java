package troller.tests.adsNearTrafficLights.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="advertisement")
public class Advertisement {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name="content")
    public String content;

    @Column(name="timestamp")
    @CreationTimestamp
    public LocalDateTime timestamp;

    public void setId(Long id){
        this.id = id;
    }

    public void setContent(String content){
        this.content = content;
    }

    public void setTimeStamp(LocalDateTime timestamp){
        this.timestamp = timestamp;
    }

    public Long getId(){
        return this.id;
    }

    public String getContent(){
        return this.content;
    }

    public LocalDateTime getTimeStamp(){
        return this.timestamp;
    }

}
