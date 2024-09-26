import javax.crypto.*;
import java.security.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class Temp58 {
    public static void main(String[] args) {
        try {
            String password = "your_password";
            byte[] salt = new byte[8]; // Generate a random 64-bit (8 bytes) salt
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextBytes(salt);

            int iterations = 1000;

            PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray(), salt, iterations, 256);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] keyBytes = secretKeyFactory.generateSecret(pbeKeySpec).getEncoded();

            Mac m = Mac.getInstance("HmacSHA1");
            m.init(new SecretKeySpec(keyBytes, "HmacSHA1"));

            // Example usage of the Mac instance to compute a MAC value
            String data = "data_to_protect";
            byte[] macResult = m.doFinal(data.getBytes());
            System.out.println(javax.xml.bind.DatatypeConverter.printHexBinary(macResult));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}