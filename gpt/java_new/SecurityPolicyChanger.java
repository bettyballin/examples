import java.security.Security;

public class SecurityPolicyChanger {
    public static void main(String[] args) {
        Security.setProperty("crypto.policy", "unlimited");
    }
}