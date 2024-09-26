import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

public class Temp820 {
    public static void main(String[] args) {
        // Example usage
        byte[] dbHash = new byte[]{1, 2, 3};  // Replace with actual hash
        String password = "password";
        byte[] salt = new byte[]{4, 5, 6};    // Replace with actual salt

        boolean result = check(dbHash, password, salt);
        System.out.println("Password match: " + result);
    }

    public static boolean check(byte[] dbHash, String password, byte[] salt) {
        try {
            return Arrays.equals(dbHash, generateHash(password, salt));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            // Handle the exception appropriately
            throw new RuntimeException("Error checking hash", e);
        }
    }

    public static byte[] generateHash(String password, byte[] salt) 
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        // Dummy implementation, replace with actual hash generation logic
        return new byte[]{1, 2, 3};  // Replace with actual hash logic
    }
}