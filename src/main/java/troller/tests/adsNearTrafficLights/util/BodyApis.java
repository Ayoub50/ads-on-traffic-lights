package troller.tests.adsNearTrafficLights.util;

import java.util.List;
import java.util.Map;

public class BodyApis {
    
    /**
     * 
     * @param requiredFields This should be mapped into db so that i dont have to create it via code and can be dynamically changed
     * @param data body of the rest request
     */
    public static void isMissingRequiredField(List<String> requiredFields, Map<String, Object> data){
        for (String field : requiredFields) {
            if (!data.containsKey(field)) {
                throw new IllegalArgumentException("Missing required field: " + field);
            }
        }
    }

}
