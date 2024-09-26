import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import java.util.HashMap;
import java.util.Map;

public class Temp57 {
    public static void main(String[] args) {

        CustomCallbackHandler callbackHandler = new CustomCallbackHandler();
        Map<String, String> myMap = new HashMap<>();
        myMap.put("username", "user1");
        myMap.put("password", "password1");
        callbackHandler.setSharedState(myMap);

        try {
            LoginContext lc = new LoginContext("MyApp", null, callbackHandler, new MyConfiguration());
            lc.login();

            // Now you can retrieve the username and password from shared state
            String userName = (String) callbackHandler.getSharedState().get("username");
            char[] passWord = ((String) callbackHandler.getSharedState().get("password")).toCharArray();

            System.out.println("Username: " + userName);
            System.out.println("Password: " + new String(passWord));
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}

class CustomCallbackHandler {
    private Map<String, String> sharedState;

    public void setSharedState(Map<String, String> sharedState) {
        this.sharedState = sharedState;
    }

    public Map<String, String> getSharedState() {
        return sharedState;
    }

    // Implement the necessary callback handling methods here
}

// Dummy MyConfiguration class for the sake of completeness
class MyConfiguration extends javax.security.auth.login.Configuration {
    @Override
    public AppConfigurationEntry[] getAppConfigurationEntry(String name) {
        return new AppConfigurationEntry[0];
    }
}