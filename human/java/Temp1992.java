import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Temp1992 {
    public static void main(String[] args) {
        try {
            byte[] hashedPassword = hash("examplepassword");
            for (byte b : hashedPassword) {
                System.out.printf("%02x", b);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static byte[] hash(String password) throws NoSuchAlgorithmException {
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        byte[] passBytes = password.getBytes();
        byte[] passHash = sha256.digest(passBytes);
        return passHash;
    }
}