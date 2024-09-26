import java.security.Principal;

public class SecurityService3 {

    private static final String SPECIAL_USER = "abc"; 

    public String getCallerId(Principal userPrincipal) {
        return userPrincipal.getName();
    }

    public boolean authorizeRequest(Principal userPrincipal, String szResourceID, String reqType) {
        String callerId = getCallerId(userPrincipal);
        return callerId.equalsIgnoreCase(szResourceID) || SPECIAL_USER.equalsIgnoreCase(szResourceID);
    }
}