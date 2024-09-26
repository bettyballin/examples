import java.util.List;
import java.util.Arrays;

public class Temp484 {

    public static void main(String[] args) {
        Temp484 temp = new Temp484();
        SecurityContext context = new SecurityContext("user123");
        System.out.println(temp.authorizeRequest(context, "user123", "read"));  // Expected to be true
    }

    public boolean authorizeRequest(SecurityContext osc, String szResourceID, String reqType) {
        // Check if resource ID is a special user and should be excluded from validation
        List<String> exceptionList = getExceptionUsers();
        if (exceptionList.contains(szResourceID)) return true;

        if( getCallerId(osc).equalsIgnoreCase(szResourceID))
            return true;
        return false; 
    }

    private List<String> getExceptionUsers() {
        return Arrays.asList("admin", "superuser");
    }

    private String getCallerId(SecurityContext osc) {
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