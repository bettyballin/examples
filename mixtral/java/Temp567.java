public class Temp567 {
    public static void main(String[] args) {

        GoogleOAuthDetails googleOAuthDetails = new GoogleOAuthDetails();
        googleOAuthDetails.setAccessType("offline");

        // Add this line
        googleOAuthDetails.addAdditionalParameter("access_type", "offline");

        // Also add the following parameter to get refresh token
        googleOAuthDetails.addAdditionalParameter("include_granted_scopes", "true");
    }
}

class GoogleOAuthDetails {
    private String accessType;

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public void addAdditionalParameter(String key, String value) {
        // Implementation of adding additional parameters
        System.out.println("Added parameter: " + key + " = " + value);
    }
}