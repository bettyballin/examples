import java.security.Security;

public class Main33 {
    public static void main(String[] args) {
        Security.setProperty("crypto.policy", "unlimited");
    }
}