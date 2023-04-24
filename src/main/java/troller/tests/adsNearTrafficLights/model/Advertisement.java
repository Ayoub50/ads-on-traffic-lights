package troller.tests.adsNearTrafficLights.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="advertisement")
public class Advertisement {
    
    public String id;
    public String content;
    public LocalDateTime timestamp;

    public void setId(String id){
        this.id = id;
    }

    public void setContent(String content){
        this.content = content;
    }

    public void setTimeStamp(LocalDateTime timestamp){
        this.timestamp = timestamp;
    }

    public String getId(){
        return this.id;
    }

    public String getContent(){
        return this.content;
    }

    public LocalDateTime getTimeStamp(){
        return this.timestamp;
    }

}
