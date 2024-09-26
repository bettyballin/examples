import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class LicenseManager {
    private static final String SECRET_KEY = "your-secret-key";

    public static String generateLicenseKey(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest((data + SECRET_KEY).getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String data = "exampleData";
        String licenseKey = generateLicenseKey(data);
        System.out.println("License Key: " + licenseKey);
    }
}