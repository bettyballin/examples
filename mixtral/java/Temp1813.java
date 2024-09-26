import org.springframework.security.oauth2.provider.OAuth2AuthenticationDetails;

import java.util.HashMap;

public class Temp1813 {
    public static void main(String[] args) {
        // Mock authentication details for demonstration purposes
        OAuth2AuthenticationDetails oauthDetails = new OAuth2AuthenticationDetails(null) {
            @Override
            public Map<String, Object> getDecodedDetails() {
                HashMap<String, Object> mockDetails = new HashMap<>();
                mockDetails.put("key", "value");
                return mockDetails;
            }
        };

        // Assuming OAuth2AuthenticationDetails is set properly
        HashMap<String, Object> additionalInformationMap = (HashMap<String, Object>) oauthDetails.getDecodedDetails();
        System.out.println(additionalInformationMap);
    }
}