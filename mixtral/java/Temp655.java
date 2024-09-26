import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Temp655 {
    public static void main(String[] args) {
        // Example usage
        SecurityContext osc = new SecurityContext("abc");
        String szResourceID = "resource123";
        String reqType = "typeA";
        
        Temp655 temp = new Temp655();
        boolean isAuthorized = temp.authorizeRequest(osc, szResourceID, reqType);
        System.out.println("Is authorized: " + isAuthorized);
    }

    public boolean authorizeRequest(SecurityContext osc, String szResourceID, String reqType) {
        // List or set containing special usernames
        Set<String> specialUsers = new HashSet<>(Arrays.asList("abc", "def"));

        if (specialUsers.contains(getCallerId(osc))) {
            return true;
        }

        if (getCallerId(osc).equalsIgnoreCase(szResourceID)) { // check for logged-in user and user specified in web-service url
            return true;
        }

        return false;
    }

    private String getCallerId(SecurityContext osc) {
        // Dummy implementation to get the caller ID from SecurityContext
        return osc.getCallerId();
    }
}

class SecurityContext {
    private String callerId;

    public SecurityContext(String callerId) {
        this.callerId = callerId;
    }

    public String getCallerId() {
        return callerId;
    }
}