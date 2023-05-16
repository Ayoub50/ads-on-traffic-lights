package troller.tests.adsNearTrafficLights.dto;

public class AuthResponse {
    private String token;
    private String userType;

    public void setToken(String token){
        this.token = token;
    }

    public String getToken(){
        return this.token;
    }

    public void setUserType(String userType){
        this.userType = userType;
    }

    public String getUserType(){
        return this.userType;
    }
    
}