import javax.crypto.Mac;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;

public class Temp811 {
    public static void main(String[] args) {
        String password = "password";
        byte[] salt = "salt".getBytes();
        
        try {
            byte[] key = pbkdf2(password, salt, 1000, 16);
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(key, "HmacSHA1"));

            byte[] macResult = mac.doFinal("message".getBytes());
            for (byte b : macResult) {
                System.out.printf("%02x", b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] pbkdf2(String password, byte[] salt, int iterations, int keyLength) 
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, keyLength * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        return skf.generateSecret(spec).getEncoded();
    }
}