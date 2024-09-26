import java.net.URI;
import java.security.Policy;
import java.security.URIParameter;

public class CustomSecurityManagerSetup {
    public static void main(String[] args) {
        try {
            URI myPolicyFileUri = new URI("file:///path/to/your/policy/file.policy");
            Policy policy = Policy.getInstance("JavaPolicy", new URIParameter(myPolicyFileUri));
            Policy.setPolicy(policy);

            System.setSecurityManager(new SecurityManager());

            // Your application logic here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}