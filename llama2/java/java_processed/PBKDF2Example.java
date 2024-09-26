import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PBKDF2Example {
    public static void main(String[] args) throws Exception {
        String password = "my_secret_password"; // Your password
        byte salt[] = new byte[] { 0x12, 0x34, 0x56, 0x78 }; // A random salt

        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, 100, 256); // Specify key length
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecretKey secretKey = skf.generateSecret(keySpec);

        System.out.println("Derived key: " + bytesToHex(secretKey.getEncoded()));
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}