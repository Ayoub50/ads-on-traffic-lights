package troller.tests.adsNearTrafficLights.util;

import java.util.List;
import java.util.Map;

public class BodyApis {
    
    public static void isMissingRequiredField(List<String> requiredFields, Map<String, Object> data){
        for (String field : requiredFields) {
            if (!data.containsKey(field)) {
                throw new IllegalArgumentException("Missing required field: " + field);
            }
        }
    }

}
