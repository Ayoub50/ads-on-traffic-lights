package troller.tests.adsNearTrafficLights.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@JsonSerialize(as = StoplightResponse.class)
public class StoplightResponse {
    private Long id;
    private Double longitude;
    private Double latitude;
    private boolean redColor;
    private boolean yellowColor;
    private boolean greenColor;
    private LocalDateTime timestamp;

    public Double getLongitude(){
        return this.longitude;
    }

    public Double getLatitude(){
        return this.latitude;
    }

    public LocalDateTime getTimestamp(){
        return this.timestamp;
    }

    public Long getId(){
        return this.id;
    }

    public boolean getRedColor(){
        return this.redColor;
    }

    public boolean getYellowColor(){
        return this.yellowColor;
    }

    public boolean getGreenColor(){
        return this.greenColor;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRedColor(boolean redColor) {
        this.redColor = redColor;
    }

    public void setYellowColor(boolean yellowColor) {
        this.yellowColor = yellowColor;
    }

    public void setGreenColor(boolean greenColor) {
        this.greenColor = greenColor;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}

