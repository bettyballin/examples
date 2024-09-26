public class Temp2325 {
    public static void main(String[] args) {

        String baseUrl = "https://example.com";  // Define the base URL
        String registrationId = "my-registration-id";  // Define the registration ID
        
        String acsUrl = baseUrl + Saml2WebSsoAuthenticationFilter.DEFAULT_FILTER_PROCESSES_URI;
        
        RelyingPartyRegistration relyingPartyRegistration = RelyingPartyRegistration
            .withRegistrationId(registrationId)
            // Define other necessary configurations here
            .assertionConsumerServiceLocation(acsUrl)
            .build();
        
        // Print the resulting object or use it as needed
        System.out.println(relyingPartyRegistration);
    }
}

// Mock classes to make the code executable
class Saml2WebSsoAuthenticationFilter {
    public static final String DEFAULT_FILTER_PROCESSES_URI = "/saml2/authenticate";
}

class RelyingPartyRegistration {
    private String registrationId;
    private String acsLocation;
    
    private RelyingPartyRegistration(String registrationId, String acsLocation) {
        this.registrationId = registrationId;
        this.acsLocation = acsLocation;
    }
    
    public static Builder withRegistrationId(String registrationId) {
        return new Builder(registrationId);
    }
    
    @Override
    public String toString() {
        return "RelyingPartyRegistration{" +
                "registrationId='" + registrationId + '\'' +
                ", acsLocation='" + acsLocation + '\'' +
                '}';
    }
    
    public static class Builder {
        private String registrationId;
        private String acsLocation;
        
        public Builder(String registrationId) {
            this.registrationId = registrationId;
        }
        
        public Builder assertionConsumerServiceLocation(String acsLocation) {
            this.acsLocation = acsLocation;
            return this;
        }
        
        public RelyingPartyRegistration build() {
            return new RelyingPartyRegistration(registrationId, acsLocation);
        }
    }
}