import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.authc.AuthenticationToken;

public class Main {
    public static void main(String[] args) {
        // Assuming necessary configurations and setup for Shiro have been done
        Subject currentUser = SecurityUtils.getSubject();
        // CustomUsernamePasswordToken is assumed to be your custom class extending AuthenticationToken
        CustomUsernamePasswordToken token = (CustomUsernamePasswordToken) currentUser.getPrincipals().oneByType(AuthenticationToken.class);
        String attribute1 = token.getAttribute1();
        
        // Use attribute1 as needed
        System.out.println("Attribute1: " + attribute1);
    }
}

// Assuming this is your custom token class
class CustomUsernamePasswordToken implements AuthenticationToken {
    private String attribute1;

    public CustomUsernamePasswordToken(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute1() {
        return attribute1;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }
}


Note: This code assumes that you have a proper Shiro configuration and setup in place.