import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

public class Temp371 {
    public static void main(String[] args) {
        try {
            String inputPassword = "password123";
            String dbStoredHash = "ef92b778bafee3c2dcf6c9b9d0bcb6a2bf1d0a776bde2a95f5c4b8e9e5d5df4a";  // Example hash for "password123"

            boolean isValid = new Temp371().validatePassword(inputPassword, dbStoredHash);
            System.out.println("Password is valid: " + isValid);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public boolean validatePassword(String inputPassword, String dbStoredHash) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // Convert the entered password to hexadecimal format
        byte[] digest = md.digest(inputPassword.getBytes());

        String inputHashedHex = DatatypeConverter.printHexBinary(digest).toLowerCase();

        return dbStoredHash.equalsIgnoreCase(inputHashedHex);
    }
}