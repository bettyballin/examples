// Convert the given JavaScript code to executable Java code

public class Temp2365 {
    public static void main(String[] args) {
        // Simulating the Ember and BaseAuthorizer objects in Java
        Ember ember = new Ember();
        BaseAuthorizer baseAuthorizer = new BaseAuthorizer();

        // Creating a sessionData object for demonstration purposes
        SessionData sessionData = new SessionData("sampleAccessToken");

        // Creating a block function to mimic the behavior
        Block block = (header, value) -> System.out.println(header + ": " + value);

        // Authorize method logic
        authorize(sessionData, block, ember, baseAuthorizer);
    }

    public static void authorize(SessionData sessionData, Block block, Ember ember, BaseAuthorizer baseAuthorizer) {
        String userToken = sessionData.getAccessToken();

        if (ember.isPresent(userToken)) {
            block.apply("Authorization", "Bearer " + userToken);
        } else {
            ember.debug("Could not find the authorization token in the session data for the jwt authorizer.");
        }
    }
}

// Simulated Ember class
class Ember {
    public boolean isPresent(String value) {
        return value != null && !value.isEmpty();
    }

    public void debug(String message) {
        System.out.println("DEBUG: " + message);
    }
}

// Simulated BaseAuthorizer class
class BaseAuthorizer {
}

// Simulated SessionData class
class SessionData {
    private String accessToken;

    public SessionData(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }
}

// Functional interface for the block function
@FunctionalInterface
interface Block {
    void apply(String header, String value);
}