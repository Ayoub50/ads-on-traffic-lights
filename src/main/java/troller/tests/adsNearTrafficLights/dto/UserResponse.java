package troller.tests.adsNearTrafficLights.dto;

public class UserResponse {

    private String username;
    private Long id;
    private String role;
    
    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public void setRole(String role){
        this.role = role;
    }

    public String getRole(){
        return this.role;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return this.id;
    }

}

